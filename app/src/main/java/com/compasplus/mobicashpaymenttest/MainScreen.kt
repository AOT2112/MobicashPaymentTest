package com.compasplus.mobicashpaymenttest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.compasplus.mobicashpaymenttest.data.PreviewFaqTestData
import com.compasplus.mobicashpaymenttest.ui.components.GroupTitle
import com.compasplus.mobicashpaymenttest.ui.components.Plate
//import com.compasplus.mobicashpaymenttest.ui.components.SearchBar
import com.compasplus.mobicashpaymenttest.ui.components.SecondaryScreen
import com.compasplus.mobicashpaymenttest.ui.components.SimpleSearchBar

//import com.compasplus.mobicashpaymenttest.ui.theme.White70
//import com.compasplus.mobicashpaymenttest.ui.theme.colorSchemeLocal

//import com.compasplus.mobicashpaymenttest.ui.theme.localColorScheme

class MainScreen : ComponentActivity() {
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
//val inputText = reme

@Composable
fun ScreenContent(data : Map<String?, List<JsonLoader.FaqDataItem>>) {
    val modifier = Modifier.padding(horizontal = 10.dp)
    SecondaryScreen(stringResource(R.string.faq_title)) {
        SimpleSearchBar(modifier.padding(vertical = 13.dp))
        FaqPayload(data, modifier/*.padding(top = 5.dp)*/)
    }
}

@Composable
fun FaqPayload(groups: Map<String?, List<JsonLoader.FaqDataItem>>, modifier: Modifier = Modifier) {
    val payloadModifier = modifier.fillMaxWidth()
        //.padding(horizontal = 5.dp)
        //.verticalScroll(ScrollState(0))

//    Column(
//        modifier = payloadModifier,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        for (group in groups) {
//            FaqGroup(group.key, group.value)
//        }
//    }

    LazyColumn(
        modifier = payloadModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        items(groups) { group ->
//
//        }

        for (group in groups) {
            item {
                FaqGroup(group.key, group.value)
            }
//            val groupNameText = group.key
//            if (groupNameText != null) {
//                item {
//                    //GroupTitle(groupNameText, groupNameModifier)
//                    //FaqGroup(group.key, group.value)
//                }
//            }
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
//    Column(
//        modifier = Modifier.padding(vertical = 10.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
    if (groupNameText != null) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val expanded = remember { mutableStateOf(true) }
            val groupNameModifier = Modifier.padding(vertical = 5.dp)
                .padding(start = 5.dp)
                .weight(20f)
                .fillMaxWidth()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val iconColors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = MaterialTheme.colorScheme.primary,
                )
                GroupTitle(groupNameText, groupNameModifier)
                IconButton(
                    onClick = { expanded.value = !expanded.value },
                    modifier = Modifier.fillMaxHeight(),//.height(10.dp),
                    colors = iconColors
                ) {
                    Icon(
                        imageVector = if (expanded.value)
                            Icons.Outlined.KeyboardArrowUp else
                            Icons.Outlined.KeyboardArrowDown,
                        contentDescription = "Expander",
//                        modifier = Modifier.toggleable(
//                            expanded.value,
//                            onValueChange = { expanded.value = it }
//                        ),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (expanded.value)
                FaqBlock(items)
        }
    }
    else
        FaqBlock(items)
    //FaqBlock(items)
}
//}

@Composable
fun FaqBlock(faqDataItems : List<JsonLoader.FaqDataItem>) {
    //val color = MaterialTheme.colorScheme.onBackground
    Plate {
        Column(modifier = Modifier.fillMaxWidth()
//            .shadow(5.dp, shape = RoundedCornerShape(10.dp))
//            .clip(shape = RoundedCornerShape(10.dp))
        ) {
            for (item in faqDataItems) {
                FaqButton(item)
                if (item != faqDataItems.last()) {
                    FaqSplitter()
                }
            }
        }
    }
}

@Composable
fun FaqSplitter() {
    Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)
        .height(1.dp)
        .fillMaxWidth())
}

@Composable
fun FaqButton(faqDataItem: JsonLoader.FaqDataItem) {
    //val colorScheme = localColorScheme.current
    //val colorScheme = LightColorScheme
//    val buttonColors : ButtonColors = ButtonColors(
//        colorScheme.onPrimary,
//        colorScheme.onBackground,
//        colorScheme.onPrimary,
//        colorScheme.onBackground
//    )

    //val buttonCode = remember { faqDataItem.Code }
    val context = LocalContext.current
    val buttonCode = faqDataItem.Code
    val buttonColors = ButtonColors(
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
        onClick = {
            Log.d("MainScreen", "Start AnswerScreen with code $buttonCode")
            val intent = Intent(context, AnswerScreen::class.java)
            intent.putExtra("Question", faqDataItem.Question)
            intent.putExtra("Answer", faqDataItem.Answer)
            context.startActivity(intent)
                  },
        modifier = Modifier.fillMaxWidth(),
            //.heightIn(35.dp, 50.dp),
            //.requiredHeight(40.dp),
            //.padding(vertical = 5.dp)
            //.aspectRatio(1f),
            shape = RectangleShape,
            colors = buttonColors,
            contentPadding = PaddingValues(horizontal = 7.dp, vertical = 10.dp)
            //contentPadding = PaddingValues(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                faqDataItem.Question,
                modifier = Modifier.weight(15f),//.padding(vertical = 7.dp),//.padding(horizontal = 2.dp),
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
                        //.padding(horizontal = 2.dp/*, vertical = 5.dp*/)
                        .fillMaxHeight(),
                        //.clipToBounds(),
                    contentDescription = "ArrowRight",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true/*, uiMode = Configuration.UI_MODE_NIGHT_YES*/)
@Composable
fun MainScreenPreview() {
    val testData = PreviewFaqTestData().prepareTestData()
    ScreenContent(testData)
}