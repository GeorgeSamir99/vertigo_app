# Vertigo AI Theming & Design System

If you are building new features, fixing UI bugs, or structuring video processing screens, this guide is your source of truth for keeping Vertigo AI's interface looking like a modern, cinematic Hollywood camera tool.

---

## What Is This?
We are building a **Responsive, Cinematic UI on top of Material 3**.

Instead of building rigid interfaces, we have designed a native Compose theme wrapper (`VertigoTheme`) that handles two major dynamic changes on the fly:
1. **Strict Cinematic Palette:** Ensuring our custom dark cyan, slate, and AI purple tones remain consistent across the app to maintain that high-contrast, professional editing software feel.
2. **Screen Scaling:** Adapting padding, text sizes, and media viewports smoothly whether the user is on a small phone, a compact device, or a large tablet (critical for video preview accuracy).

---

## Problems We Are Solving

### 1. Maintaining the Cinematic Illusion (The "Washed Out" Bug)
* **The Old Problem:** Default Material 3 dark modes rely heavily on generic charcoal grays and bright purples, which makes the app look like a standard utility rather than a premium video tool. Hardcoding hex colors on every screen leads to inconsistencies.
* **Our Solution:** We mapped out a custom `Color.kt` that strictly overrides Material 3's `darkColorScheme`. By using deep cyan-tinted backgrounds (`#091114`) and slate surfaces, the vibrant primary Cyan (`#00B7C2`) pops organically. Every color property is backed by Compose state management, ensuring smooth transitions and absolute consistency across the UI.

### 2. Layouts Exploding on Small Phones or Dissolving on Tablets
* **The Old Problem:** Hardcoding exact dimensions like `Modifier.padding(24.dp)` or `fontSize = 16.sp` is an anti-pattern. It causes text to clip on small devices and leaves massive empty spacing when rendering video preview windows on larger screens.
* **Our Solution:** We run a lightweight runtime engine that measures the device's real estate (`WindowSizeClass`) via `LocalConfiguration` and automatically swaps out configuration rules (`AppTheme.dimens.mediumLarge`, `AppTheme.typography.headlineMedium`) to match the hardware context perfectly.

---

## 📦 Reusable Core Components

To keep everything unified, do not write custom native Material buttons, video frames, or headers from scratch. Always utilize these core components from the `core.components` package:

* **`VertigoPrimaryButton`**: The main primary action button across screens (e.g., "Generate Vertigo Effect", "Save Video"). Supports active, disabled, and automated `loading = true` state management (replaces text with a correctly tinted loader).
* **`VertigoIconButton`**: Transparent or surface-tinted buttons for UI controls, toolbars, and scrubbers.
* **`MediaPreviewBox`**: Handles video frames, image uploads, and AI processing states cleanly. Supports progress loading states (with AI purple accents) and manages fallback error placeholders seamlessly.
* **`CameraBadgeText`**: Specific text component utilizing `JetBrains Mono` with tabular numerals (`fontFeatureSettings = "tnum"`) and wide tracking for timecodes (00:14) and status tags (4K, SUBJECT DETECTED).
* **`VertigoBottomSheet`**: Standard slide-up contextual dialog drawer for Paywall plans, Export settings, and share sheets. Manages internal vertical scroll states and viewport scaling.

---

## 💻 How to Use It in Code

### 1. Accessing Design System Tokens
Whenever you are building a Composable, never hardcode values. Always pull tokens from the `AppTheme` object:

```kotlin
@Composable
fun ProUpgradeCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(AppTheme.dimens.medium),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.surfaceVariant
        ),
        shape = AppTheme.shapes.medium
    ) {
        AppText(
            text = "Create Cinematic Masterpieces",
            style = AppTheme.typography.headlineMedium,
            color = AppTheme.colors.onSurface
        )
    }
}
```

### 2. Wiring Up Custom Previews
Use our custom theme wrapper to ensure that the dark cinematic colors and typography scaling are applied correctly in the Android Studio preview pane.

```kotlin
@Previews
@Composable
fun ProUpgradeCardPreview() {
    PreviewContainer {
        ProUpgradeCard()
    }
}
```

## Golden Rules for Refactoring
* Never use raw `.dp` or `.sp` directly on views. Always fall back to `AppTheme.dimens` or `AppTheme.typography`.
* Never hardcode hex colors. Always use `AppTheme.colors` (e.g., `AppTheme.colors.primary` for cyan CTAs, `AppTheme.colors.tertiary` for purple AI magic).
