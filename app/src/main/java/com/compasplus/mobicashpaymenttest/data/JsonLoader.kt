package com.compasplus.mobicashpaymenttest.data

import android.content.Context
import androidx.compose.ui.text.AnnotatedString
import com.compasplus.mobicashpaymenttest.R
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader

class JsonLoader(context : Context) {
    private val oldAppName = "%SUBST_APPLICATION_NAME%"
    private val newAppName = context.getString(R.string.app_name)
    private val localContext = context

    fun getFaqData (): FaqMap {
        var jsonText = readJsonFile()
        jsonText = jsonText.replace(oldAppName, newAppName, false)
        val faqDataItems = Json.Default.decodeFromString<Array<FaqJsonItem>>(jsonText)
        return convertToFaqMap(faqDataItems)

//        val faqData = faqDataItems.groupBy(keySelector = { it.Subject })
//        return FaqMap(faqData)
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

    private fun convertToFaqMap(faqDataItems : Array<FaqJsonItem>) : FaqMap {
        val list = faqDataItems.map {
            FaqDataItem(
                code = it.Code,
                subject = it.Subject,
                question = AnnotatedString(it.Question),
                answer = androidx.compose.ui.text.AnnotatedString(it.Answer)
            )
        }

        val faqData = list.groupBy(keySelector = { it.subject })
        return FaqMap(faqData)
    }
}