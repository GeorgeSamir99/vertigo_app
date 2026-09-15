package com.georgeayad.vertigoapp.ui.theme

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection

@Composable
internal fun PreviewContainer(
    modifier: Modifier = Modifier,
    lightColors: ColorScheme = LightColors,
    darkColors: ColorScheme = DarkColors,
    darkTheme: Boolean = isSystemInDarkTheme(),
    layoutDirection: LayoutDirection = LayoutDirection.Rtl,
    content: @Composable () -> Unit
) {
    VertigoTheme(
        lightColors = lightColors,
        darkColors = darkColors,
        darkTheme = darkTheme,
    ) {
        CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
            Surface(color = MaterialTheme.colorScheme.background) {
                Box(modifier) {
                    content()
                }
            }
        }
    }
}

@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION)
// --- PHONE (Compact Scale) ---
@Preview(name = "Phone - Dark", device = "spec:width=393dp,height=851dp", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Phone - Light", device = "spec:width=393dp,height=851dp", showBackground = true)
// --- TABLET LANDSCAPE (Large/Big Scale) ---
@Preview(name = "Tablet | Landscape - Light", device = "spec:width=1280dp,height=800dp", showBackground = true)
internal annotation class Previews