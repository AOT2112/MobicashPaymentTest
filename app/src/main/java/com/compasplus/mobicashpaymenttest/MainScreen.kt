package com.compasplus.mobicashpaymenttest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.compasplus.mobicashpaymenttest.data.FaqDataItem
import com.compasplus.mobicashpaymenttest.data.FaqMap
import com.compasplus.mobicashpaymenttest.ui.components.GroupTitle
import com.compasplus.mobicashpaymenttest.ui.components.Plate
import com.compasplus.mobicashpaymenttest.ui.components.SecondaryScreen
import com.compasplus.mobicashpaymenttest.ui.components.SimpleSearchBar
import com.compasplus.mobicashpaymenttest.ui.screens.main.FaqViewModel

class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val speechInputManager = SpeechInputManager(this)
        enableEdgeToEdge()
        setContent {
            ScreenContent(speechInputManager)
        }
    }

}

@Composable
fun ScreenContent(
    speechInput: SpeechInputManager,
    viewModel : FaqViewModel = viewModel()
) {
    val data = viewModel.faqData.value
    val state = viewModel.faqState.value
    val modifier = Modifier.padding(horizontal = 10.dp)
    SecondaryScreen(stringResource(R.string.faq_title)) {
        if (data != null) {
            when (state) {
                FaqViewModel.FaqDataState.OK -> {
                    FaqSearchBar(viewModel, speechInput, modifier)
                    FaqPayload(data, modifier /*modifier.padding(bottom = 10.dp).padding(top = 5.dp)*/)
                }
                FaqViewModel.FaqDataState.LOADING_ERROR -> {
                    PlainText(stringResource(R.string.data_loading_error))
                }
                FaqViewModel.FaqDataState.QUERY_NOT_FOUND -> {
                    FaqSearchBar(viewModel, speechInput, modifier)
                    PlainText(stringResource(R.string.data_searching_not_found))
                }
            }
        }
    }
}

@Composable
fun FaqSearchBar(
    viewModel: FaqViewModel,
    speechInput: SpeechInputManager,
    modifier: Modifier = Modifier
) {
    SimpleSearchBar(viewModel, speechInput, modifier.padding(vertical = 13.dp))
}

@Composable
fun PlainText(text : String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onSurface,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize
    )
}

@Composable
fun FaqPayload(data: FaqMap, modifier: Modifier = Modifier) {
    val payloadModifier = modifier.fillMaxWidth()

    LazyColumn(
        modifier = payloadModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        for (group in data.items) {
            item {
                FaqGroup(group.key, group.value)
            }
        }
    }
}

@Composable
fun FaqGroup(groupNameText : String?, items : List<FaqDataItem>) {
    if (groupNameText != null) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val expanded = rememberSaveable { mutableStateOf(true) }
            val groupNameModifier = Modifier//.padding(vertical = 5.dp)
                .padding(start = 5.dp)
                .weight(15f)
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
                    modifier = Modifier.weight(1f).fillMaxHeight(),//.height(10.dp),
                    colors = iconColors
                ) {
                    Icon(
                        imageVector = if (expanded.value)
                            Icons.Outlined.KeyboardArrowUp else
                            Icons.Outlined.KeyboardArrowDown,
                        contentDescription = "Expander",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (expanded.value)
                FaqBlock(items)
            else
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.primary)
                    .height(1.dp).fillMaxWidth())
        }
    }
    else
        FaqBlock(items)
}

@Composable
fun FaqBlock(faqDataItems : List<FaqDataItem>) {
    //val color = MaterialTheme.colorScheme.onBackground
    Plate(Modifier.padding(bottom = 10.dp)) {
        Column(modifier = Modifier.fillMaxWidth()
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
fun FaqButton(faqDataItem: FaqDataItem) {
    //val buttonCode = remember { faqDataItem.Code }
    val context = LocalContext.current
    val buttonCode = faqDataItem.code
    val buttonColors = ButtonColors(
        MaterialTheme.colorScheme.surface,
        MaterialTheme.colorScheme.onSurface,
        MaterialTheme.colorScheme.surface,
        MaterialTheme.colorScheme.onSurface
    )

    Button(
        onClick = {
            Log.d("MainScreen", "Start AnswerScreen with code $buttonCode")
            val intent = Intent(context, AnswerScreen::class.java)
            intent.putExtra("Question", faqDataItem.question)
            intent.putExtra("Answer", faqDataItem.answer)
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
                faqDataItem.question,
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