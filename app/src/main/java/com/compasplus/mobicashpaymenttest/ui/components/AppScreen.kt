package com.compasplus.mobicashpaymenttest.ui.components

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.compasplus.mobicashpaymenttest.ui.theme.MobicashPaymentTestTheme

val ShadowElevation : Dp = 5.dp
val CornerShape : RoundedCornerShape = RoundedCornerShape(5.dp)

@Composable
fun SecondaryScreen(
    title : String,
    modifier: Modifier = Modifier,
    content : @Composable (() -> Unit)
) {
    MobicashPaymentTestTheme {
        val activity = LocalActivity.current
        Column(
            modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .windowInsetsPadding(WindowInsets.safeDrawing)
        ) {
            SimpleTopBar(
                title,
                onClickBackButton = { activity?.finish() }
            )
            content()
        }
    }
}