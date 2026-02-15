package com.compasplus.mobicashpaymenttest.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFE6E6E6),
    secondary = Color(0xFFE6E6E6),
    tertiary = Pink80,


    background = Color(0xFF1C1B1F),
    surface = Color(0xFF303030),
    onPrimary = Color(0xFF1C1B1F),
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color(0xFFBEBEBE),
    onSurface = Color(0xFFBEBEBE)
)

val LightColorScheme = lightColorScheme(
    primary = Color(0xFFE6E6E6),
    secondary = Color(0xFFE6E6E6),
    tertiary = Color(0xFFBE1E24),

    // Other default colors to override
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
    background = Color(0xFFBEBEBE), // 0xFFEFEFEF
    surface = Color.White, // 0xFFEFEFEF
    onPrimary = Color(0xFFBEBEBE),
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),

)

//public var colorSchemeLocal : ColorScheme = LightColorScheme
//val localColorScheme = staticCompositionLocalOf { LightColorScheme }

@Composable
fun MobicashPaymentTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    //localColorScheme provides colorScheme
    //colorSchemeLocal = colorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}