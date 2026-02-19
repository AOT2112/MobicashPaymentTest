package com.compasplus.mobicashpaymenttest.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString

val searchHighlightStyle = SpanStyle(
    color = Color.Black,
    background = Color.Yellow
)

fun addHighlight(matches : List<MatchResult>, text: AnnotatedString) : AnnotatedString {
    val result = buildAnnotatedString {
        append(text)
        matches.forEach {
            addStyle(searchHighlightStyle, it.range.first, it.range.last)
        }
    }
    return result
}