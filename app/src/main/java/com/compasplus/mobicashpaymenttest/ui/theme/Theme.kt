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
    primary = White90,
    secondary = LightGray75,
    tertiary = Pink80,


    background = Black90,
    surface = DarkGray80,
    onPrimary = Black90,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = LightGray75,
    onSurface = LightGray75

)

val LightColorScheme = lightColorScheme(
    primary = Gray50,
    secondary = Gray50,
    tertiary = Red75,

    background = White95,
    surface = Color.White,
    surfaceTint = White85,
    surfaceVariant = LightGray60,
    onPrimary = White95,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,

    )

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