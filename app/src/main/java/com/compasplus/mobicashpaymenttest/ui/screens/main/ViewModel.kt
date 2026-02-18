package com.compasplus.mobicashpaymenttest.ui.screens.main

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.compasplus.mobicashpaymenttest.data.JsonLoader
import com.compasplus.mobicashpaymenttest.data.FaqMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FaqViewModel(application: Application) : AndroidViewModel(application) {
    enum class FaqDataState(val value: Byte) {
        LOADING_ERROR(-1),
        OK(0),
        QUERY_NOT_FOUND(1)
    }
    private var allFaqData : FaqMap? = null
    val faqData = mutableStateOf(allFaqData)
    val faqState = mutableStateOf(FaqDataState.OK)

    init {
        val jsonLoader = JsonLoader(getApplication())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                allFaqData = jsonLoader.getFaqData()
            }
            catch (exc : Exception) {
                faqState.value = FaqDataState.LOADING_ERROR
            }
            withContext(Dispatchers.Main) {
                reset()
            }
        }
    }

    fun find(query : String) {

    }

    fun reset() {
        if (faqState.value == FaqDataState.QUERY_NOT_FOUND)
            faqState.value = FaqDataState.OK
        faqData.value = allFaqData
    }
}