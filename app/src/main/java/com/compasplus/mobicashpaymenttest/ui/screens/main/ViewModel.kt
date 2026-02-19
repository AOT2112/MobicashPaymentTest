package com.compasplus.mobicashpaymenttest.ui.screens.main

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.compasplus.mobicashpaymenttest.data.JsonLoader
import com.compasplus.mobicashpaymenttest.data.FaqMap
import com.compasplus.mobicashpaymenttest.data.SearchManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FaqViewModel(application: Application) : AndroidViewModel(application) {
    enum class FaqDataState(val value: Byte) {
        LOADING_ERROR(-1),
        OK(0),
        QUERY_NOT_FOUND(1)
    }
    private val searchManager = SearchManager()
    private var searchCoroutine : Job? = null
    private var allFaqData : FaqMap? = null
    val faqData = mutableStateOf(allFaqData)
    val faqState = mutableStateOf(FaqDataState.OK)

    init {
        val jsonLoader = JsonLoader(getApplication())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                allFaqData = jsonLoader.getFaqData()
            }
            catch (_ : Exception) {
                faqState.value = FaqDataState.LOADING_ERROR
            }
            withContext(Dispatchers.Main) {
                reset()
            }
        }
    }

    fun find(query : String) {
        if (searchCoroutine?.isActive ?: false) {
//            Log.d("ViewModel.find", "Cancelling the coroutine")
            searchCoroutine?.cancel()
        }
        if (query.isNotEmpty() && query.isNotBlank()) {
            searchCoroutine = viewModelScope.launch {
//                Log.d("ViewModel.find.coroutineScope", "Start of coroutine")
                delay(4000)
//                Log.d("ViewModel.find.coroutineScope", "Waiting completed")
//                Log.d("ViewModel.find.coroutineScope", "Searching $query")

                withContext(Dispatchers.Main) {
                    allFaqData?.let {
                        val foundedData = searchManager.findText(query, it)
                        faqData.value = foundedData
                        faqState.value = if (foundedData.items.isEmpty()) {
                            FaqDataState.QUERY_NOT_FOUND
                        } else {
                            FaqDataState.OK
                        }
                    }
                }
                //delay(1000)
//                allFaqData?.let {
//                    faqData.value = searchManager.findText(query, it)
//                }

//                Log.d("ViewModel.find.coroutineScope", "Searching completed")
//                Log.d("ViewModel.find.coroutineScope", "End of coroutine")
            }
        }
        else
            reset()

//        if (query.isNotBlank()) {
//            allFaqData?.let { searchManager.findText(query, it) }
//        }
//        else
//            reset()
    }

    private fun reset() {
        if (faqState.value == FaqDataState.QUERY_NOT_FOUND)
            faqState.value = FaqDataState.OK
        faqData.value = allFaqData
    }
}