package com.example.customer.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customer.ui.theme.*


@Preview(showBackground = true)
@Composable
fun PreviewCustomFoodOtherScreen() {
    CustomFoodOtherScreen()
}

@Composable
fun CustomFoodOtherScreen() {
    val colorSelected = remember {
        mutableStateOf(bgMainWhile)
    }
    val textColorSelected = remember {
        mutableStateOf(Black)
    }

    Column {
        Text(
            text = "Chọn Món Kèm Theo",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.6f)
        )

        val animations = listOf(
            "Nước Mắm Cay",
            "Nước Mắm Thường",
            "Giá Sống",
            "Giá Trụng",
            "Rau Đầy Đủ",
            "Không Rau"
        )
        var animationIndex by remember { mutableStateOf(true) }
        VerticalGrid(columns = 2, modifier = Modifier.padding(vertical = 12.dp)) {
            animations.forEachIndexed { index, title ->
                Button(
                    onClick = {
                        if (animationIndex) {
                            colorSelected.value = colorButtonChoose
                            textColorSelected.value = bgMainWhile
                        } else {
                            colorSelected.value = bgMainWhile
                            textColorSelected.value = Black
                        }
                        animationIndex = !animationIndex

                    },
                    border = BorderStroke(1.dp, colorButtonChoose),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorSelected.value),
                    modifier = Modifier
                        .padding(5.dp),
                    shape = CircleShape
                ) {
                    Text(text = "$title", color = textColorSelected.value, fontSize = 13.sp)
                }
            }
        }
    }
}

@Composable
fun VerticalGrid(
    modifier: Modifier = Modifier,
    columns: Int = 2,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val itemWidth = constraints.maxWidth / columns
        // Keep given height constraints, but set an exact width
        val itemConstraints = constraints.copy(
            minWidth = itemWidth,
            maxWidth = itemWidth
        )
        // Measure each item with these constraints
        val placeables = measurables.map { it.measure(itemConstraints) }
        // Track each columns height so we can calculate the overall height
        val columnHeights = Array(columns) { 0 }
        placeables.forEachIndexed { index, placeable ->
            val column = index % columns
            columnHeights[column] += placeable.height
        }
        val height = (columnHeights.maxOrNull() ?: constraints.minHeight)
            .coerceAtMost(constraints.maxHeight)
        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            // Track the Y co-ord per column we have placed up to
            val columnY = Array(columns) { 0 }
            placeables.forEachIndexed { index, placeable ->
                val column = index % columns
                placeable.placeRelative(
                    x = column * itemWidth,
                    y = columnY[column]
                )
                columnY[column] += placeable.height
            }
        }
    }
}