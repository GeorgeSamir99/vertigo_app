package com.georgeayad.vertigoapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.georgeayad.vertigoapp.R

private val InterFontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
        Font(R.font.inter_bold, FontWeight.Bold),
        Font(R.font.inter_regular, FontWeight.Normal),
        Font(R.font.inter_light, FontWeight.Light)
    )

private const val FONT_SCALE = 0.93f

private fun createTextStyle(
    size: Float,
    family: FontFamily,
    weight: FontWeight = FontWeight.Normal,
    lineHeightMultiplier: Float = 1.5f,
    letterSpacingEm: Double = 0.0
) = TextStyle(
    fontFamily = family,
    fontWeight = weight,
    fontSize = (size * FONT_SCALE).sp,
    lineHeight = (size * lineHeightMultiplier * FONT_SCALE).sp,
    letterSpacing = letterSpacingEm.em
)

@Composable
internal fun generateTypography(sizeClass: WindowSize): Typography {
    val family = InterFontFamily

    return when (sizeClass) {
        is WindowSize.Small -> createTypographySet(family, 12f, 14f, 16f, 16f, 18f, 22f, 24f, 26f, 28f)
        is WindowSize.Compact -> createTypographySet(family, 13f, 15f, 17f, 18f, 20f, 24f, 26f, 30f, 34f)
        is WindowSize.Medium -> createTypographySet(family, 14f, 16f, 18f, 20f, 22f, 26f, 30f, 34f, 38f)
        else -> createTypographySet(family, 18f, 22f, 24f, 24f, 28f, 32f, 36f, 40f, 48f)
    }
}

private fun createTypographySet(
    family: FontFamily,
    bS: Float, bM: Float, bL: Float,
    tS: Float, tM: Float, tL: Float,
    hS: Float, hM: Float, hL: Float
) = Typography(
    // Body: Crisp legibility using Light and Regular
    bodySmall = createTextStyle(bS, family, FontWeight.Light),
    bodyMedium = createTextStyle(bM, family, FontWeight.Normal),
    bodyLarge = createTextStyle(bL, family, FontWeight.Normal),

    // Titles: Using Bold with slightly tighter tracking for UI elements
    titleSmall = createTextStyle(tS, family, FontWeight.Bold, letterSpacingEm = -0.01),
    titleMedium = createTextStyle(tM, family, FontWeight.Bold, letterSpacingEm = -0.01),
    titleLarge = createTextStyle(tL, family, FontWeight.Bold, letterSpacingEm = -0.01),

    // Headlines: Maximum punch with ExtraBold and negative tracking
    headlineSmall = createTextStyle(hS, family, FontWeight.ExtraBold, 1.2f, letterSpacingEm = -0.02),
    headlineMedium = createTextStyle(hM, family, FontWeight.ExtraBold, 1.2f, letterSpacingEm = -0.02),
    headlineLarge = createTextStyle(hL, family, FontWeight.ExtraBold, 1.2f, letterSpacingEm = -0.03)
)