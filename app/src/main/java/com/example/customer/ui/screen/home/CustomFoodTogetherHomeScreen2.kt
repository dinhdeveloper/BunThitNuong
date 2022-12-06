package com.example.customer.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PreviewCustomFoodTogetherHomeScreen2() {
    PreviewCustomFoodTogetherHomeScreen2()
}

@Composable
fun CustomFoodTogetherHomeScreen2() {
    Column {
        Text(
            text = "Chọn Món Kèm Theo",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.6f)
        )

    }
    FoodTogetherItem2()
}

@Composable
fun FoodTogetherItem2() {

}
