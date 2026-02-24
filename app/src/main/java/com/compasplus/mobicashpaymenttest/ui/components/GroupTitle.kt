package com.compasplus.mobicashpaymenttest.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight

@Composable
fun GroupTitle(
    text: String,
    modifier : Modifier = Modifier
) {
    GroupTitleLocal(AnnotatedString(text), modifier)
}

@Composable
fun GroupTitle(
    text: AnnotatedString,
    modifier : Modifier = Modifier
) {
    GroupTitleLocal(text, modifier)
}

@Composable
private fun GroupTitleLocal(
    annotatedText: AnnotatedString,
    modifier : Modifier = Modifier
) {
    val text = annotatedText.text.uppercase()
    Text(
        AnnotatedString(text, annotatedText.spanStyles),
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        fontWeight = FontWeight.Bold
    )
}