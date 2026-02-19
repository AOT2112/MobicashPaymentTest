package com.compasplus.mobicashpaymenttest.data
/*
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

// Временно конвертируем AnnotatedString в промежуточный класс
@Serializable
data class AnnotatedStringHolder(
    val text: String,
    val spanStyles: List<AnnotatedStringRange<SpanStyle>>,
    val paragraphStyles: List<AnnotatedStringRange<ParagraphStyle>>
)

@Serializable
data class AnnotatedStringRange<T>(
    val item: T,
    val start: Int,
    val end: Int
)

// Вспомогательные функции
fun AnnotatedString.serialize(): String {
    val spanStyles = this.spanStyles.map {
        AnnotatedStringRange(it.item, it.start, it.end)
    }
    val paragraphStyles = this.paragraphStyles.map {
        AnnotatedStringRange(it.item, it.start, it.end)
    }
    val holder = AnnotatedStringHolder(
        text = this.text,
        spanStyles = spanStyles,
        paragraphStyles = paragraphStyles
    )
    return Json.encodeToString(holder)
}

fun String.deserializeAnnotatedString(): AnnotatedString {
    val holder = Json.decodeFromString<AnnotatedStringHolder>(this)
    return AnnotatedString(
        text = holder.text,
        spanStyles = holder.spanStyles.map { range ->
            AnnotatedString.Range(range.item, range.start, range.end)
        },
        paragraphStyles = holder.paragraphStyles.map { range ->
            AnnotatedString.Range(range.item, range.start, range.end)
        }
    )
}
*/
