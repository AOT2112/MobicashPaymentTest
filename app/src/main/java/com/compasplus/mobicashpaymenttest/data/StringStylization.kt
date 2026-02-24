package com.compasplus.mobicashpaymenttest.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight

val searchHighlightStyle = SpanStyle(
    color = Color.Black,
    background = Color.Yellow
)
val paragraphBoldStyle = SpanStyle(
    fontWeight = FontWeight.Bold
)
val regexParagraphFinder = Regex("""\n\n.+?\.""")

fun getAnnotatedFromHighlighted(highlightedString: HighlightedString) : AnnotatedString {
    val result = buildAnnotatedString {
        append(highlightedString.text)
        highlightedString.range.forEach {
            addStyle(searchHighlightStyle, it.start, it.end)
        }
    }
    return result
}

fun addParagraphBolding(annotatedString : AnnotatedString) : AnnotatedString {
    val matches = regexParagraphFinder.findAll(annotatedString).toList()
    val result = buildAnnotatedString {
        append(annotatedString)
        matches.forEach {
            addStyle(paragraphBoldStyle, it.range.first, it.range.last + 1)
        }
    }
    return result
}