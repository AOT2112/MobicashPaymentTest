package com.compasplus.mobicashpaymenttest.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun GroupTitle(
    text: String,
    modifier : Modifier = Modifier
) {
    Text(
        text.uppercase(),
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        fontWeight = FontWeight.Bold
    )
}