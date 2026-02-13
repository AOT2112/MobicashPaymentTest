package com.compasplus.mobicashpaymenttest

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
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
            ScreenContent(data)
//            CompositionLocalProvider(localContext provides this) {
//
//            }
        }
    }
}

//val localContext = staticCompositionLocalOf<Context?> { null }

@Composable
fun ScreenContent(/*context : Context?, */data : Map<String?, List<JsonLoader.FaqDataItem>>) {
    MobicashPaymentTestTheme {
//                val data = remember { mutableStateOf(jsonLoader.getFaqData()) }
        //val context = localContext.current
        //if (context != null) {
            Column(
                Modifier.fillMaxSize()
            ) {
                @OptIn(ExperimentalMaterial3Api::class)
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.faq_title),
                            color = MaterialTheme.colorScheme.tertiary,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                )
                FaqPayload(data, Modifier.padding(top = 40.dp))
            }
        //}
//                Scaffold(
//                    modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    FaqPayload(data, Modifier.padding(innerPadding))
//                }
    }
}

@Composable
fun FaqPayload(groups: Map<String?, List<JsonLoader.FaqDataItem>>, modifier: Modifier = Modifier) {
    val payloadModifier = Modifier.fillMaxWidth()
        .padding(horizontal = 5.dp)
        .verticalScroll(ScrollState(0))
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
                color = MaterialTheme.colorScheme.primary,
                modifier = groupNameModifier,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = FontWeight.Bold
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
        contentColor = MaterialTheme.colorScheme.onSurface,
        shadowElevation = 5.dp,
    ) {
        Column(modifier = Modifier.fillMaxWidth()
//            .shadow(5.dp, shape = RoundedCornerShape(10.dp))
//            .clip(shape = RoundedCornerShape(10.dp))
        ) {
            for (item in items) {
                FaqButton(item.Question)
                if (item != items.last()) {
                    Box(modifier = Modifier.background(MaterialTheme.colorScheme.primary)
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
        MaterialTheme.colorScheme.surface,
        MaterialTheme.colorScheme.onSurface,
        MaterialTheme.colorScheme.surface,
        MaterialTheme.colorScheme.onSurface
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
            contentPadding = PaddingValues(horizontal = 7.dp, vertical = 5.dp)
            //contentPadding = PaddingValues(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text,
                modifier = Modifier.weight(15f),//.padding(horizontal = 2.dp),
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                textAlign = TextAlign.Left
            )
            Box(
                modifier = Modifier.weight(1f).fillMaxHeight(),//.requiredWidth(6.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    modifier = Modifier//.weight(1f)
                        .padding(/*horizontal = 2.dp,*/ vertical = 5.dp)
                        .fillMaxHeight()
                        .clipToBounds(),
                    contentDescription = "ArrowRight",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true/*, uiMode = Configuration.UI_MODE_NIGHT_YES*/)
@Composable
fun ScreenPreview() {
    val testData = PreviewTestData().prepareTestData()
    ScreenContent(testData)
}