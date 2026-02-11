package com.compasplus.mobicashpaymenttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.compasplus.mobicashpaymenttest.ui.theme.MobicashPaymentTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jsonLoader = JsonLoader(this)
        val data = jsonLoader.getFaqData()
        enableEdgeToEdge()
        setContent {
            MobicashPaymentTestTheme {
//                val data = remember { mutableStateOf(jsonLoader.getFaqData()) }
                FaqPayload(data)
            }
        }
    }
}
@Composable
fun FaqPayload(groups: Map<String?, List<JsonLoader.FaqDataItem>>)
{
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val payloadModifier = Modifier.fillMaxSize()
            .padding(horizontal = 5.dp)
            .padding(innerPadding)
        Column(payloadModifier, horizontalAlignment = Alignment.CenterHorizontally) {
            for (group in groups) {
                FaqGroup(group.key, group.value)
            }
        }
//        val myModifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//            .border(width = 2.dp, color = Color.DarkGray)
//            .background(Color.LightGray)
////            .clip(shape= CircleShape)
//            .padding(20.dp)
//            .padding(innerPadding)
//        Message("Test message", myModifier)
    }
}
//@Composable
//fun Message(text: String, textModifier: Modifier = Modifier) {
//    Text(text, textModifier, fontSize = 28.sp, textAlign = TextAlign.Center)
//}

@Composable
fun FaqGroup(groupNameText : String?, items : List<JsonLoader.FaqDataItem>) {
    val columnModifier = Modifier.padding(vertical = 5.dp)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (groupNameText != null) {
            val groupNameModifier = Modifier.padding(vertical = 10.dp)
                .fillMaxWidth()
            Text(groupNameText.uppercase(), groupNameModifier)
        }
        FaqBlock(items)
    }
}

@Composable
fun FaqBlock(items : List<JsonLoader.FaqDataItem>) {
    Column(modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))) {
        for (item in items) {
            FaqButton(item.Question)
        }
    }
}

@Composable
fun FaqButton(text: String) {
    Button(
        onClick = {  },
        shape = RectangleShape
    ) {
        Text(text, fontSize = 20.sp, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    MobicashPaymentTestTheme {
        //FaqPayload()
    }
}