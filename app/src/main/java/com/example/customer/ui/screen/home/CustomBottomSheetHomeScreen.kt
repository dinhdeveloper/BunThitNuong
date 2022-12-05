package com.example.customer.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.customer.ui.theme.colorButton2
import com.example.customer.ui.theme.colorToolbar
import dinhtc.android.customer.R


@Preview(showBackground = true)
@Composable
fun PreviewCustomBottomSheetHomeScreen() {
    CustomBottomSheetHomeScreen()
}


@Composable
fun CustomBottomSheetHomeScreen() {
    Box(
        Modifier
            .clip(CircleShape)
            .size(70.dp)
            .background(colorToolbar)
            .border(6.dp, colorButton2, CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_plus),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center).size(18.dp)
        )
    }
}