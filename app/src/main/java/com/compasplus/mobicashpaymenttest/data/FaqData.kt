package com.compasplus.mobicashpaymenttest.data

import androidx.compose.ui.text.AnnotatedString
import kotlinx.serialization.Serializable

@Suppress("PropertyName")
@Serializable
data class FaqJsonItem(
    val Code : String,
    val Subject : String?,
    val Question : String,
    val Answer : String
)

data class FaqDataItem(
    val code : String,
    val subject : String?,
    val question : AnnotatedString,
    val answer : AnnotatedString
)
//@Serializable
//data class FaqData(val faqDataItems : Array<FaqJsonItem>) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as FaqData
//
//        return faqDataItems.contentEquals(other.faqDataItems)
//    }
//
//    override fun hashCode(): Int {
//        return faqDataItems.contentHashCode()
//    }
//}

data class FaqMap(val items : Map<String?, List<FaqDataItem>>)