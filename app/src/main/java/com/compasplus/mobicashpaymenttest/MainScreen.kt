package com.compasplus.mobicashpaymenttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.compasplus.mobicashpaymenttest.ui.theme.MobicashPaymentTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobicashPaymentTestTheme {
                Payload()
            }
        }
    }
}
@Composable
fun Payload()
{
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val myModifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(width = 2.dp, color = Color.DarkGray)
            .background(Color.LightGray)
//            .clip(shape= CircleShape)
            .padding(20.dp)
            .padding(innerPadding)
        Message("Test message", myModifier)
    }
}
@Composable
fun Message(text: String, textModifier: Modifier = Modifier) {
    Text(text, textModifier, fontSize = 28.sp, textAlign = TextAlign.Center)
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    MobicashPaymentTestTheme {
        Payload()
    }
}