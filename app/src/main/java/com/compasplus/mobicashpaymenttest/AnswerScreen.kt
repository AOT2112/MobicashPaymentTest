package com.compasplus.mobicashpaymenttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compasplus.mobicashpaymenttest.data.HighlightedString
import com.compasplus.mobicashpaymenttest.data.getAnnotatedFromHighlighted
import com.compasplus.mobicashpaymenttest.ui.components.GroupTitle
import com.compasplus.mobicashpaymenttest.ui.components.Plate
import com.compasplus.mobicashpaymenttest.ui.components.SecondaryScreen
import kotlinx.serialization.json.Json

class AnswerScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val questionJson = intent.getStringExtra("Question")
        val answerJson = intent.getStringExtra("Answer")
        //val code = intent.getStringExtra("Code")

        val question = Json.decodeFromString<HighlightedString>(questionJson ?: "")
        val answer = Json.decodeFromString<HighlightedString>(answerJson ?: "")

        enableEdgeToEdge()
        setContent {
            ScreenContent(
                getAnnotatedFromHighlighted(question),
                getAnnotatedFromHighlighted(answer)
            )
        }
    }
}

@Composable
fun ScreenContent(question : AnnotatedString, answer : AnnotatedString) {
    SecondaryScreen(stringResource(R.string.faq_title)) {
        if (question.text.isNotEmpty() && answer.text.isNotEmpty()) {
            FaqGroup(question, answer)
        }
    }
}

@Composable
fun FaqGroup(question : AnnotatedString, answer : AnnotatedString) {
    Column(
        modifier = Modifier.padding(vertical = 10.dp)
            .fillMaxWidth()
            .verticalScroll(ScrollState(0)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val groupNameModifier = Modifier.padding(vertical = 5.dp)
            .padding(start = 10.dp)
            .fillMaxWidth()
        GroupTitle(question, groupNameModifier)
        Plate(modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth()) {
            Text(
                answer,
                modifier = Modifier.padding(10.dp).fillMaxSize(),
                //color = MaterialTheme.colorScheme.onSurface,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                textAlign = TextAlign.Left
            )
        }
    }
}