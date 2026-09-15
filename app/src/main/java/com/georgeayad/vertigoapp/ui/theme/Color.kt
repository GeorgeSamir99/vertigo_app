package com.georgeayad.vertigoapp.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Minimal, accurate tokens for your specific UI
internal val DarkColors = darkColorScheme(
    // The vibrant cyan for buttons and active states
    primary = Color(0xFF00B7C2),
    onPrimary = Color(0xFF001F22),

    // The AI magic purple for progress and scanning
    tertiary = Color(0xFF8B5CF6),
    onTertiary = Color.White,

    // The TRUE background: a deep, dark cyan-tinted night sky
    background = Color(0xFF091114),
    onBackground = Color(0xFFFFFFFF),

    // Elevated cards and bottom sheets (slightly lighter dark-cyan)
    surface = Color(0xFF131B1F),
    onSurface = Color(0xFFE2E8F0),

    // Nested elements or highlighted cards (like the Pro tier box)
    surfaceVariant = Color(0xFF1B272C),
    onSurfaceVariant = Color(0xFF94A3B8),

    // Subtle borders for cards and dividers
    outline = Color(0xFF263840)
)

// Simplified Light Mode (if you even plan to use it)
internal val LightColors = lightColorScheme(
    primary = Color(0xFF006870),
    onPrimary = Color.White,
    tertiary = Color(0xFF8B5CF6),
    background = Color(0xFFF0F4F5), // Light slate tint
    onBackground = Color(0xFF091114),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF091114),
    surfaceVariant = Color(0xFFE1E8EB),
    outline = Color(0xFFB0BEC5)
)