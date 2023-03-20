package com.mumbicodes.fibonacci.presentation.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColorScheme(
    primary = Orange80,
    onPrimary = Orange10,
    primaryContainer = Orange30,
    onPrimaryContainer = Orange90,

    error = Red10,
    onError = Red90,

    background = background,
    onBackground = LightestGrey,

    surface = DarkestGrey,
    onSurface = LightGrey,
    inverseSurface = SubtleGrey,
    inverseOnSurface = Grey,

    outline = SubtleGrey
)

private val LightColorPalette = lightColorScheme(
    primary = OrangeMain,
    onPrimary = Orange90,
    primaryContainer = Orange80,
    onPrimaryContainer = Orange90,

    error = RedMain,
    onError = Red90,

    background = LightestGrey,
    onBackground = DarkestGrey,

    surface = White,
    onSurface = DarkerGrey,
    inverseSurface = Grey,
    inverseOnSurface = SubtleGrey,

    outline = SubtleGrey
)

@Composable
fun FibonacciTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            val insets = WindowCompat.getInsetsController(window, view)
            window.statusBarColor = if (darkTheme) DarkColorPalette.background.toArgb() else LightColorPalette.background.toArgb() // choose a status bar color
            // window.navigationBarColor = LightColorPalette.surface.toArgb() // choose a navigation bar color
            insets.isAppearanceLightStatusBars = !darkTheme
            // insets.isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
