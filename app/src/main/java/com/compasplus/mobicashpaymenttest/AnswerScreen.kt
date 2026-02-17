package com.compasplus.mobicashpaymenttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compasplus.mobicashpaymenttest.data.PreviewFaqTestData
import com.compasplus.mobicashpaymenttest.ui.components.GroupTitle
import com.compasplus.mobicashpaymenttest.ui.components.Plate
import com.compasplus.mobicashpaymenttest.ui.components.SecondaryScreen
import com.compasplus.mobicashpaymenttest.ui.theme.MobicashPaymentTestTheme

class AnswerScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val question = intent.getStringExtra("Question")
        val answer = intent.getStringExtra("Answer")
        enableEdgeToEdge()
        setContent {
            ScreenContent(question, answer)
        }
    }
}

@Composable
fun ScreenContent(question : String?, answer : String?) {
    SecondaryScreen(stringResource(R.string.faq_title)) {
        if (question != null && answer != null) {
            FaqGroup(question, answer)
        }
    }
}

@Composable
fun FaqGroup(question : String, answer : String) {
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AnswerScreenPreview() {
    val faqDataItem = PreviewFaqTestData().oneItem
    val question = faqDataItem.Question
    val answer = faqDataItem.Answer
    ScreenContent(question, answer)
}