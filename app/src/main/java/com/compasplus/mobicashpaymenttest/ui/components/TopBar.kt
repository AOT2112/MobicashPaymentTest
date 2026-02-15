package com.compasplus.mobicashpaymenttest.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.compasplus.mobicashpaymenttest.R

@Composable
fun SimpleTopBar(
    title : String,
    modifier: Modifier = Modifier,
    onClickBackButton: () -> Unit
) {
    @OptIn(ExperimentalMaterial3Api::class)
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 17.sp,
                textAlign = TextAlign.Center
            )
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = { onClickBackButton.invoke() }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "ArrowBack",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    )
}