package com.example.thitnuong.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thitnuong.ui.theme.bgMainWhile
import com.example.thitnuong.ui.theme.bgProduct

@Preview(showBackground = true)
@Composable
fun PreviewCustomSizeFoodHomeScreen() {
    CustomSizeFoodHomeScreen()
}


@Composable
fun CustomSizeFoodHomeScreen() {
    Row(

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(bgMainWhile)
                .padding(5.dp)
                .height(130.dp)
                .weight(1f)
                .border(
                    1.dp,
                    bgProduct,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 5.dp)
        ) {

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(bgMainWhile)
                .padding(5.dp)
                .height(130.dp)
                .weight(1f)
                .border(
                    1.dp,
                    bgProduct,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 5.dp)
        ) {

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(bgMainWhile)
                .padding(5.dp)
                .weight(1f)
                .height(130.dp)
                .border(
                    1.dp,
                    bgProduct,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 5.dp)
        ) {

        }
    }
}