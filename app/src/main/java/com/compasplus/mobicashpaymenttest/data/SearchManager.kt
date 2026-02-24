package com.compasplus.mobicashpaymenttest.data

class SearchManager() {
    val regexSplitter : Regex = Regex("""[\s,!?.]+""") // Splitter by words. Determines start of word

    fun findText(query : String, faqMap: FaqMap) : FaqMap {
        val queryWords = query.split(regexSplitter)
        val newMap = mutableMapOf<String?, List<FaqDataItem>>()
        faqMap.items.forEach { mapItem ->
            val newList = mutableListOf<FaqDataItem>()
            mapItem.value.forEach { listItem ->
                val questionMatches = mutableListOf<HighlightedTextRange>()
                val answerMatches = mutableListOf<HighlightedTextRange>()
                queryWords.forEach { word ->
                    if (word.length >= 2) {
                        // Regular Expression for search a current word
                        val regexWord = Regex(
                            word,
                            setOf(RegexOption.IGNORE_CASE, RegexOption.MULTILINE)
                        )

                        fun getMatchResults(text: String): List<HighlightedTextRange> {
                            val matches = regexWord.findAll(text).map {
                                with(it.range) {
                                    HighlightedTextRange(first, last + 1)
                                }
                            }
                            return matches.toList()
                        }

                        questionMatches.addAll(getMatchResults(listItem.question.text))
                        answerMatches.addAll(getMatchResults(listItem.answer.text))
                    }
                }

                if (questionMatches.isNotEmpty() || answerMatches.isNotEmpty()) {
                    newList.add(FaqDataItem(
                        listItem.code,
                        listItem.subject,
                        HighlightedString(listItem.question.text, questionMatches),
                        HighlightedString(listItem.answer.text, answerMatches)
                    ))
                }
            }
            if (newList.isNotEmpty())
                newMap[mapItem.key] = newList.toList()
        }
        return FaqMap(newMap.toMap())
    }
}