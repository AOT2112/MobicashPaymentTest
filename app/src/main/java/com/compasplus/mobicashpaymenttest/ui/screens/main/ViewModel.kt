package com.compasplus.mobicashpaymenttest.ui.screens.main

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compasplus.mobicashpaymenttest.data.JsonLoader
import com.compasplus.mobicashpaymenttest.data.FaqMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FaqViewModel(context: Context) : ViewModel() {
    private var allFaqData : FaqMap? = null
    private var displayFaqData : FaqMap? = null
    val faqData = mutableStateOf(displayFaqData)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val jsonLoader = JsonLoader(context)
            allFaqData = jsonLoader.getFaqData()
            withContext(Dispatchers.Main) {
                displayFaqData = allFaqData
            }
        }
    }

    fun Find(query : String) {

    }

    fun Reset() {
        displayFaqData = allFaqData
    }
}