package com.example.thitnuong.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.thitnuong.ui.theme.*
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@Preview(showBackground = true)
@Composable
fun PreviewCustomSizeFoodHomeScreen() {
    CustomSizeFoodHomeScreen()
}


@Composable
fun CustomSizeFoodHomeScreen() {
    Row {
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
                    bgOgran,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 5.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = bgOgran.copy(alpha = 0.5f),
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
                text = "100.000 VNĐ",
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 10.dp),
                color = Black
            )
        }

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
                    Gray,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 5.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onBackground.copy(alpha = 0.1f),
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
                text = "150.000 VNĐ",
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 10.dp),
                color = Black
            )
        }

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
                    Gray,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 5.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onBackground.copy(alpha = 0.1f),
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
                text = "200.000 VNĐ",
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