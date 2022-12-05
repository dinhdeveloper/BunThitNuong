package com.example.thitnuong.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thitnuong.ui.theme.Black
import com.example.thitnuong.ui.theme.bgMainWhile
import dinhtc.android.thitnuong.R


@Preview(showBackground = true)
@Composable
fun PreviewCustomTitleHomeScreen() {
    CustomTitleHomeScreen()
}


@Composable
fun CustomTitleHomeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bún Thịt Nướng",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            color = Black.copy(alpha = 0.9f)
        )
        Text(
            text = "1 phần - 300g",
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            modifier = Modifier.padding(top = 7.dp),
            color = Black.copy(alpha = 0.7f)
        )

        Image(
            painter = painterResource(id = R.drawable.img_icon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 15.dp)
                .size(200.dp)
                .clip(CircleShape)
        )

    }
}