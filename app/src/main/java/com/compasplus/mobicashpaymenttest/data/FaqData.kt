package com.compasplus.mobicashpaymenttest.data

import kotlinx.serialization.Serializable

@Suppress("PropertyName")
@Serializable
data class FaqJsonItem(
    val Code : String,
    val Subject : String?,
    val Question : String,
    val Answer : String
)

data class FaqDataItem (
    val code : String,
    val subject : String?,
    val question : HighlightedString,
    val answer : HighlightedString
)

data class FaqMap(val items : Map<String?, List<FaqDataItem>>)