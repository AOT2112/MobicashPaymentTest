package com.compasplus.mobicashpaymenttest

import android.content.Context
import androidx.compose.ui.res.stringResource
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Dictionary

class JsonLoader(context : Context) {
    private val oldAppName = "%SUBST_APPLICATION_NAME%"
    private val newAppName = context.getString(R.string.app_name)
    private val localContext = context
    @Serializable
    data class FaqDataItem(
        val Code : String,
        val Subject : String?,
        val Question : String,
        val Answer : String
    )

    @Serializable
    data class FaqData(val faqDataItems : Array<FaqDataItem>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as FaqData

            return faqDataItems.contentEquals(other.faqDataItems)
        }

        override fun hashCode(): Int {
            return faqDataItems.contentHashCode()
        }
    }

    public fun getFaqData (): Map<String?, List<JsonLoader.FaqDataItem>> {
        var jsonText = readJsonFile()
        jsonText = jsonText.replace(oldAppName, newAppName, false)
        val faqDataItems = Json.decodeFromString<Array<FaqDataItem>>(jsonText)
        return faqDataItems.groupBy(keySelector = { it.Subject })
    }

    private fun readJsonFile() : String {
        val fileName : String = "FaqDictionary.json"
        val reader = BufferedReader(
            InputStreamReader(
                localContext.assets.open(fileName),
                "UTF-8"
            )
        )
        return reader.use { it.readText() }
    }
}