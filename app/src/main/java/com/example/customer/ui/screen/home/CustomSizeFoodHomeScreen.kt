package com.example.customer.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customer.common.format.FormatNumber
import com.example.customer.ui.theme.*
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@Preview(showBackground = true)
@Composable
fun PreviewCustomSizeFoodHomeScreen() {
    CustomSizeFoodHomeScreen(30000,
        setMoneySizeS = {

        },
        setMoneySizeM = {

        },
        setMoneySizeL = {

        }
    )
}


@Composable
fun CustomSizeFoodHomeScreen(
    textCountAll: Int,
    setMoneySizeS: (Int) -> Unit,
    setMoneySizeM: (Int) -> Unit,
    setMoneySizeL: (Int) -> Unit,
) {
    val moneyS = 30000
    val moneyM = 35000
    val moneyL = 40000
    Row {
        var colorSizeS by remember { mutableStateOf(colorButtonChoose) }
        var colorSizeM by remember { mutableStateOf(Gray) }
        var colorSizeL by remember { mutableStateOf(Gray) }

        var stateSizeS by remember { mutableStateOf(true) }
        var stateSizeM by remember { mutableStateOf(false) }
        var stateSizeL by remember { mutableStateOf(false) }

        //phan nho
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(bgMainWhile)
                .padding(5.dp)
                .height(130.dp)
                .weight(1f)
                .border(
                    1.dp,
                    colorSizeS,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 5.dp)
                .clickable {
                    stateSizeS = true
                    stateSizeM = false
                    stateSizeL = false

                    if (stateSizeS && !stateSizeM && !stateSizeL) {
                        colorSizeS = colorButtonChoose

                        colorSizeM = Gray
                        colorSizeL = Gray

                        setMoneySizeS(moneyS)
                    }

                }
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = colorSizeS.copy(alpha = 0.5f),
                        shape = CircleShape,
                    )
                    .padding(5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp.times(0.6f))
                        .myPlaceHolder(
                            visible = true,
                            shape = CircleShape,
                        ),
                )
            }

            Text(
                text = "Phần Nhỏ",
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                modifier = Modifier.padding(top = 10.dp),
                color = Black.copy(alpha = 0.5f)
            )

            Text(
                text =
                if (stateSizeS) {
                    FormatNumber.formatMoney((textCountAll * moneyS).toString())
                }else{
                    FormatNumber.formatMoney((moneyS).toString())
                },
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 10.dp),
                color = Black
            )
        }

        //phan vua
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(bgMainWhile)
                .padding(5.dp)
                .height(130.dp)
                .weight(1f)
                .border(
                    1.dp,
                    colorSizeM,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 5.dp)
                .clickable {
                    stateSizeS = false
                    stateSizeM = true
                    stateSizeL = false

                    if (!stateSizeS && stateSizeM && !stateSizeL) {
                        colorSizeM = colorButtonChoose

                        colorSizeS = Gray
                        colorSizeL = Gray

                        setMoneySizeM(moneyM)
                    }
                }
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = colorSizeM,
                        shape = CircleShape,
                    )
                    .padding(5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp.times(0.6f))
                        .myPlaceHolder(
                            visible = true,
                            shape = CircleShape,
                        ),
                )
            }

            Text(
                text = "Phần Vừa",
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                modifier = Modifier.padding(top = 10.dp),
                color = Black.copy(alpha = 0.5f)
            )

            Text(
                text =
                if (stateSizeM) {
                    FormatNumber.formatMoney((textCountAll * moneyM).toString())
                }else{
                    FormatNumber.formatMoney((moneyM).toString())
                },
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 10.dp),
                color = Black
            )
        }

        //phan to
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(bgMainWhile)
                .padding(5.dp)
                .weight(1f)
                .height(130.dp)
                .border(
                    1.dp,
                    colorSizeL,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 5.dp)
                .clickable {
                    stateSizeS = false
                    stateSizeM = false
                    stateSizeL = true

                    if (!stateSizeS && !stateSizeM && stateSizeL) {
                        colorSizeL = colorButtonChoose

                        colorSizeS = Gray
                        colorSizeM = Gray

                        setMoneySizeL(moneyL)
                    }
                }
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = colorSizeL,
                        shape = CircleShape,
                    )
                    .padding(5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp.times(0.6f))
                        .myPlaceHolder(
                            visible = true,
                            shape = CircleShape,
                        ),
                )
            }

            Text(
                text = "Phần Lớn",
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                modifier = Modifier.padding(top = 10.dp),
                color = Black.copy(alpha = 0.5f)
            )

            Text(
                text =
                if (stateSizeL) {
                    FormatNumber.formatMoney((textCountAll * moneyL).toString())
                }else{
                    FormatNumber.formatMoney((moneyL).toString())
                },
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 10.dp),
                color = Black
            )
        }
    }
}

@Composable
fun Modifier.myPlaceHolder(
    visible: Boolean,
    shape: Shape = MaterialTheme.shapes.small,
    color: Color = MaterialTheme.colors.onBackground.copy(alpha = 0.1f),
    highLightColor: Color = MaterialTheme.colors.surface,
) = this.placeholder(
    visible = visible,
    color = color,
    shape = shape,
    highlight = PlaceholderHighlight.shimmer(
        highlightColor = highLightColor
    ),
)