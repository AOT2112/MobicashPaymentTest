package com.compasplus.mobicashpaymenttest.data

import android.text.TextUtils
import androidx.compose.ui.text.AnnotatedString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchManager(/*coroutineScope: CoroutineScope*/) {
    //val coroutine = coroutineScope
    /*suspend*/
    //val regexSplitter : Regex = ""
    fun findText(query : String) : FaqMap {

        //CoroutineScope(Dispatchers.Default)

        return FaqMap(mapOf(
            "" to
            listOf(FaqDataItem
                ("",
                "",
                AnnotatedString(""),
                AnnotatedString(""))
            ))
        )
    }

    private fun findWord(word : String) {

    }
}