package com.compasplus.mobicashpaymenttest.data

class SearchManager() {
    val regexSplitter : Regex = Regex("""[\s,!?.]+""")

//    fun findText(query : String, faqMap: FaqMap) : FaqMap {
//        val queryWords = query.split(regexSplitter)
//        val newFaqMap = faqMap.copy()
//        val result = newFaqMap.items.filter { entry ->
//            val list = entry.value.forEach {
//
//            }
//        }
//
//    }

    fun findText(query : String, faqMap: FaqMap) : FaqMap {
        val queryWords = query.split(regexSplitter)
        val newFaqMap = faqMap.copy()
        val result = newFaqMap.items.filter { entry ->
            val list = entry.value.filter { item ->
                var isExist = false
                queryWords.forEach { word ->
                    val regexWord = Regex(
                        word,
                        setOf(RegexOption.IGNORE_CASE, RegexOption.MULTILINE)
                    )
                    val questionMatches = regexWord.findAll(item.question).toList()
                    val answerMatches = regexWord.findAll(item.answer).toList()
                    isExist = questionMatches.isNotEmpty() || answerMatches.isNotEmpty()
                    item.question = addHighlight(questionMatches, item.question)
                    item.answer = addHighlight(questionMatches, item.answer)
                }
                return@filter isExist
            }
//            return@filter false
            return@filter list.isNotEmpty()
        }
        return FaqMap(result)
    }
}