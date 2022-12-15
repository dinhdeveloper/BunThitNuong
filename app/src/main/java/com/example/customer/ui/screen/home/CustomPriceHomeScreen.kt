package com.example.customer.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customer.common.format.FormatNumber
import com.example.customer.ui.theme.Black
import com.example.customer.ui.theme.colorButton
import com.example.customer.ui.theme.colorButton2
import dinhtc.android.customer.R


@Preview(showBackground = true)
@Composable
fun PreviewCustomPriceHomeScreen() {
    CustomPriceHomeScreen(
        30000,
        onClickMinus = {

        },
        onClickPlus = {

        })
}

@Composable
fun CustomPriceHomeScreen(
    textMoneySize: Int,
    onClickMinus: (Int) -> Unit,
    onClickPlus: (Int) -> Unit,
) {
    var textCount by remember { mutableStateOf(1) }
    var textMoney = textMoneySize
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(colorButton, CircleShape)
    ) {
        Text(
            text = FormatNumber.formatMoney((textMoney * textCount).toString()),
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
                modifier = Modifier.clickable(
                    onClick = {
                        if (textCount <= 1) {
                            textCount = 1
                        } else {
                            textCount -= 1
                        }
                        textMoney *= textCount
                        onClickMinus(textCount)
                    }
                )
            )
            Text(
                text = textCount.toString(),
                fontSize = 14.sp,
                color = Black,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_plus_item),
                contentDescription = null,
                modifier = Modifier.clickable(
                    onClick = {
                        if (textCount >= 30) {
                            textCount = 30
                        } else {
                            textCount += 1
                        }
                        textMoney *= textCount
                        onClickPlus(textCount)
                    }
                )
            )
        }
    }
}