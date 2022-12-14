package com.example.customer.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dinhtc.android.customer.R

@Preview(showBackground = true)
@Composable
fun PreviewCustomToolbarHomeScreen() {
    CustomToolbarHomeScreen(
        onClickMenu = {

        },
        onClickProcessOrder = {

        })
}

@Composable
fun CustomToolbarHomeScreen(
    onClickMenu: () -> Unit,
    onClickProcessOrder: () -> Unit,
) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_menu_line),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 10.dp)
                .width(30.dp)
                .height(30.dp)
                .padding(5.dp)
                .clickable {
                    onClickMenu()
                }
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.ic_ring_notification),
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .padding(5.dp)
                .clickable {
                    onClickProcessOrder()
                }
        )
    }
}