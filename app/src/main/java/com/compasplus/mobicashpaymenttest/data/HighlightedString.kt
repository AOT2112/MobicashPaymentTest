package com.compasplus.mobicashpaymenttest.data

import kotlinx.serialization.Serializable

@Serializable
data class HighlightedTextRange(
    val start: Int,
    val end: Int
)

@Serializable
data class HighlightedString(
    val text : String,
    val range: List<HighlightedTextRange>
)
