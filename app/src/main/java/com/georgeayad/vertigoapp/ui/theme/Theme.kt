package com.georgeayad.vertigoapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun VertigoTheme(
    lightColors: ColorScheme= LightColors,
    darkColors: ColorScheme= DarkColors,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) darkColors else lightColors

    val windowSizeClass = rememberWindowSizeClass()

    val orientation = when {
        windowSizeClass.width.size > windowSizeClass.height.size -> Orientation.Landscape
        else -> Orientation.Portrait
    }

    val sizeThatMatters = when (orientation) {
        Orientation.Portrait -> windowSizeClass.width
        else -> windowSizeClass.height
    }

    val dimensions = when (sizeThatMatters) {
        is WindowSize.Small -> smallDimensions
        is WindowSize.Compact -> compactDimensions
        is WindowSize.Medium -> mediumDimensions
        else -> largeDimensions
    }

    val typography = generateTypography(sizeThatMatters)

    val appShapes = AppShapes(
        tiny = RoundedCornerShape(dimensions.extraSmall / 2),
        small = RoundedCornerShape(dimensions.small),
        smallMedium = RoundedCornerShape(dimensions.smallMedium),
        medium = RoundedCornerShape(dimensions.medium),
        mediumLarge = RoundedCornerShape(dimensions.mediumLarge),
        large = RoundedCornerShape(dimensions.large),
        extraLarge = RoundedCornerShape(dimensions.extraLarge),
        pill = RoundedCornerShape(percent = 50),
        topRounded = RoundedCornerShape(
            topStart = dimensions.smallMedium,
            topEnd = dimensions.smallMedium
        ),
        bottomRounded = RoundedCornerShape(
            bottomStart = dimensions.smallMedium,
            bottomEnd = dimensions.smallMedium
        )
    )

    ProvideAppUtils(dimensions = dimensions, orientation = orientation) {
        CompositionLocalProvider(
            LocalAppShapes provides appShapes,
            LocalWindowSizeClass provides windowSizeClass
        ) {
            MaterialTheme(
                colorScheme = colorScheme,
                typography = typography,
                content = content
            )
        }
    }
}