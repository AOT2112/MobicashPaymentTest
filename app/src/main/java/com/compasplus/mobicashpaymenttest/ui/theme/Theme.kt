package com.compasplus.mobicashpaymenttest.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
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
    primary = Color(0xFF7F7F7F),
    secondary = Color(0xFF7F7F7F),
    tertiary = Color(0xFFBE1E24),

    background = Color(0xFFEFEFEF),
    surface = Color.White,
    surfaceTint = Color(0xFFD6D6D6),
    surfaceVariant = Color(0xFF999999),
    onPrimary = Color(0xFFEFEFEF),
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,

)

//public var colorSchemeLocal : ColorScheme = LightColorScheme
//val localColorScheme = staticCompositionLocalOf { LightColorScheme }

@Composable
fun MobicashPaymentTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
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