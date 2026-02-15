package com.compasplus.mobicashpaymenttest

import android.os.Bundle
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.compasplus.mobicashpaymenttest.data.PreviewTestData
import com.compasplus.mobicashpaymenttest.ui.components.CornerShape
//import com.compasplus.mobicashpaymenttest.ui.components.SearchBar
import com.compasplus.mobicashpaymenttest.ui.components.SecondaryScreen
import com.compasplus.mobicashpaymenttest.ui.components.ShadowElevation

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
//val inputText = reme

@Composable
fun ScreenContent(data : Map<String?, List<JsonLoader.FaqDataItem>>) {
    val modifier = Modifier.padding(horizontal = 10.dp)
    SecondaryScreen(stringResource(R.string.faq_title)) {
        @OptIn(ExperimentalMaterial3Api::class)
        val searchState = rememberSearchBarState()
        var query by remember { mutableStateOf<String?>(null) }
        @OptIn(ExperimentalMaterial3Api::class)
        SearchBar(
            state = searchState,
            inputField = {
                val iconsColor = MaterialTheme.colorScheme.onSurface
                val textFieldColors = TextFieldDefaults.colors(
                    focusedLeadingIconColor = iconsColor,
                    unfocusedLeadingIconColor = iconsColor,
                    disabledLeadingIconColor = iconsColor,
                    errorLeadingIconColor = iconsColor,

                    focusedTrailingIconColor = iconsColor,
                    unfocusedTrailingIconColor = iconsColor,
                    disabledTrailingIconColor = iconsColor,
                    errorTrailingIconColor = iconsColor
                )
                SearchBarDefaults.InputField(
                    query = query ?: "",
                    onQueryChange = { query = it },
                    onSearch = { },
                    expanded = false,
                    onExpandedChange = { },
                    placeholder = {
                        Text(stringResource(R.string.search))
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            //tint = iconsColor
                        )
                    },
                    trailingIcon = {
                        if (query.isNullOrEmpty()) {
                            IconButton(
                                onClick = { }
                            ) {
                                Icon(
                                    Icons.Outlined.Check,
                                    contentDescription = "Voice"
                                )
                            }
                        }
                        else {
                            IconButton(
                                onClick = { query = null }
                            ) {
                                Icon(
                                    Icons.Outlined.Close,
                                    contentDescription = "Close"
                                )
                            }
                        }
                    }
                )
            },
            modifier = modifier.height(70.dp)
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            shape = CornerShape,
            //colors = SearchBarColors(MaterialTheme.colorScheme.surface, ),
            shadowElevation = ShadowElevation
        )
//        SearchBar(
//            onTextType = { },
//            modifier.padding(vertical = 10.dp)
//        )
        FaqPayload(data, modifier.padding(top = 5.dp))
    }
}

//@Composable
//fun ScreenLayout(data : Map<String?, List<JsonLoader.FaqDataItem>>) {
//    MobicashPaymentTestTheme {
//        val activity = LocalActivity.current
//        Column(
//            Modifier.fillMaxSize()
//                .background(MaterialTheme.colorScheme.background)
//                .windowInsetsPadding(WindowInsets.safeDrawing)
//        ) {
//            @OptIn(ExperimentalMaterial3Api::class)
//            CenterAlignedTopAppBar(
//                title = {
//                    Text(
//                        text = stringResource(R.string.faq_title),
//                        color = MaterialTheme.colorScheme.tertiary,
//                        fontSize = 17.sp,
//                        textAlign = TextAlign.Center
//                    )
//                },
//                navigationIcon = {
//                    IconButton(
//                        onClick = { activity?.finish() }
//                    ) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
//                            contentDescription = "ArrowBack",
//                            tint = MaterialTheme.colorScheme.tertiary
//                        )
//                    }
//                }
//            )
//            FaqPayload(data, Modifier.padding(top = 70.dp))
//        }
//        //}
////                Scaffold(
////                    modifier = Modifier.fillMaxSize()) { innerPadding ->
////                    FaqPayload(data, Modifier.padding(innerPadding))
////                }
//    }
//}

@Composable
fun FaqPayload(groups: Map<String?, List<JsonLoader.FaqDataItem>>, modifier: Modifier = Modifier) {
    val payloadModifier = modifier.fillMaxWidth()
        //.padding(horizontal = 5.dp)
        .verticalScroll(ScrollState(0))
        //.background(MaterialTheme.colorScheme.background)
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
                .padding(start = 5.dp)
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
        shape = CornerShape,
        contentColor = MaterialTheme.colorScheme.onSurface,
        shadowElevation = ShadowElevation,
    ) {
        Column(modifier = Modifier.fillMaxWidth()
//            .shadow(5.dp, shape = RoundedCornerShape(10.dp))
//            .clip(shape = RoundedCornerShape(10.dp))
        ) {
            for (item in items) {
                FaqButton(item.Question)
                if (item != items.last()) {
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
            contentPadding = PaddingValues(horizontal = 7.dp/*, vertical = 10.dp*/)
            //contentPadding = PaddingValues(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text,
                modifier = Modifier.weight(15f).padding(vertical = 7.dp),//.padding(horizontal = 2.dp),
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
fun ScreenPreview() {
    val testData = PreviewTestData().prepareTestData()
    ScreenContent(testData)
}