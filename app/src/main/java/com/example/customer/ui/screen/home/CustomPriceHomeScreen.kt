package com.example.customer.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customer.ui.theme.Black
import com.example.customer.ui.theme.colorButton
import com.example.customer.ui.theme.colorButton2
import dinhtc.android.customer.R


@Preview(showBackground = true)
@Composable
fun PreviewCustomPriceHomeScreen() {
    CustomPriceHomeScreen()
}

@Composable
fun CustomPriceHomeScreen() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(colorButton, CircleShape)
    ) {
        Text(
            text = "100.000 VNĐ",
            fontSize = 14.sp,
            color = Black,
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(colorButton2, CircleShape)
                .padding(horizontal = 10.dp, vertical = 7.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_minus_item),
                contentDescription = null,
                modifier = Modifier
            )
            Text(
                text = "10",
                fontSize = 14.sp,
                color = Black,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_plus_item),
                contentDescription = null,
                modifier = Modifier
            )
        }
    }
}