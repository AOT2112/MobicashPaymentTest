package com.compasplus.mobicashpaymenttest

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.compasplus.mobicashpaymenttest.ui.theme.DarkColorScheme
import com.compasplus.mobicashpaymenttest.ui.theme.LightColorScheme
import com.compasplus.mobicashpaymenttest.ui.theme.MobicashPaymentTestTheme
//import com.compasplus.mobicashpaymenttest.ui.theme.White70
//import com.compasplus.mobicashpaymenttest.ui.theme.colorSchemeLocal

//import com.compasplus.mobicashpaymenttest.ui.theme.localColorScheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jsonLoader = JsonLoader(this)
        val data = jsonLoader.getFaqData()
        enableEdgeToEdge()
        setContent {
            MobicashPaymentTestTheme {
//                val data = remember { mutableStateOf(jsonLoader.getFaqData()) }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FaqPayload(data, Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun FaqPayload(groups: Map<String?, List<JsonLoader.FaqDataItem>>, modifier: Modifier = Modifier)
{
    val payloadModifier = Modifier.fillMaxWidth()
        .padding(horizontal = 5.dp)
    Column(
        modifier = payloadModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (group in groups) {
            FaqGroup(group.key, group.value)
        }
    }
}
//@Composable
//fun Message(text: String, textModifier: Modifier = Modifier) {
//    Text(text, textModifier, fontSize = 28.sp, textAlign = TextAlign.Center)
//}

@Composable
fun FaqGroup(groupNameText : String?, items : List<JsonLoader.FaqDataItem>) {
    //val columnModifier = Modifier.padding(vertical = 5.dp)
    Column(
        modifier = Modifier.padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (groupNameText != null) {
            val groupNameModifier = Modifier.padding(vertical = 5.dp)
                .fillMaxWidth()
            Text(
                groupNameText.uppercase(),
                color = Color.Gray,
                modifier = groupNameModifier,
                fontSize = 13.sp
                )
        }
        FaqBlock(items)
    }
}

@Composable
fun FaqBlock(items : List<JsonLoader.FaqDataItem>) {
    //val color = MaterialTheme.colorScheme.onBackground
    Surface(
        shape = RoundedCornerShape(5.dp),
        contentColor = MaterialTheme.colorScheme.onBackground,
        shadowElevation = 5.dp,
    ) {
        Column(modifier = Modifier.fillMaxWidth()
//            .shadow(5.dp, shape = RoundedCornerShape(10.dp))
//            .clip(shape = RoundedCornerShape(10.dp))
        ) {
            for (item in items) {
                FaqButton(item.Question)
                if (item != items.last()) {
                    Box(modifier = Modifier.background(Color(0xffe6e6e6))
                        .height(1.dp)
                        .fillMaxWidth())
                }
            }
        }
    }
}

@Composable
fun FaqButton(text: String) {
    //val colorScheme = localColorScheme.current
    //val colorScheme = LightColorScheme
//    val buttonColors : ButtonColors = ButtonColors(
//        colorScheme.onPrimary,
//        colorScheme.onBackground,
//        colorScheme.onPrimary,
//        colorScheme.onBackground
//    )

    val buttonColors : ButtonColors = ButtonColors(
        MaterialTheme.colorScheme.background,
        MaterialTheme.colorScheme.onBackground,
        MaterialTheme.colorScheme.background,
        MaterialTheme.colorScheme.onBackground
    )

//    val buttonColors : ButtonColors = ButtonColors(
//        Color.White,
//        Color(0xFF1C1B1F),
//        Color.White,
//        Color(0xFF1C1B1F)
//    )


//    val buttonColors : ButtonColors =
//        when {
//            isSystemInDarkTheme() -> ButtonColors(DarkColorScheme.)
//        }
//    Box(modifier = Modifier.background(Color.White)
//        .height(15.dp)
//        .fillMaxWidth(),
//        contentAlignment = Alignment.CenterStart
//    ) {
//        Text(
//            text,
//            modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp),
//            fontSize = 12.sp,
//            textAlign = TextAlign.Left
//        )
//    }
    Button(
        onClick = {  },
        modifier = Modifier.fillMaxWidth(),
            //.heightIn(35.dp, 50.dp),
            //.requiredHeight(40.dp),
            //.padding(vertical = 5.dp)
            //.aspectRatio(1f),
            shape = RectangleShape,
            colors = buttonColors,
            contentPadding = PaddingValues(5.dp)
    ) {
        Text(
            text,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 1.dp),
            fontSize = 13.sp,
            textAlign = TextAlign.Left
        )
        //Icon()
    }
}

@Preview(showBackground = true/*, uiMode = Configuration.UI_MODE_NIGHT_YES*/)
@Composable
fun ScreenPreview() {
    MobicashPaymentTestTheme {
        val testData = PreviewTestData().prepareTestData()
        FaqPayload(testData)
    }
}