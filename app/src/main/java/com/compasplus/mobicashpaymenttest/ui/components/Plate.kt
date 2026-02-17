package com.compasplus.mobicashpaymenttest.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Plate(
    modifier: Modifier = Modifier,
    content : @Composable (() -> Unit)
) {
    Surface(
        modifier = modifier,
        shape = CornerShape,
        contentColor = MaterialTheme.colorScheme.onSurface,
        shadowElevation = ShadowElevation,
    ) {
        content()
    }
}