package com.example.customer.ui.screen.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customer.model.FoodOtherModel
import com.example.customer.ui.theme.*
import com.example.customer.viewmodel.ShareViewModel

@Preview(showBackground = true)
@Composable
fun PreviewCustomFoodOtherScreen() {
    //CustomFoodOtherScreen()
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun CustomFoodOtherScreen(
    dataFood: List<FoodOtherModel>,
    shareViewModel: ShareViewModel
) {
    val itemSelected = remember {
        mutableStateOf<FoodOtherModel?>(null)
    }

    val myItems = mutableStateListOf<FoodOtherModel>()
        .apply {
            repeat(6) {
                add(FoodOtherModel(id = it, name = dataFood[it].name))
            }
        }

    fun getSelectedItems() = myItems.filter { it.isSelected }

    fun toggleSelection(index: Int) {

        val item = myItems[index]
        val isSelected = item.isSelected

        if (isSelected) {
            myItems[index] = item.copy(isSelected = false)
            itemSelected.value = item.copy(isSelected = false)
            shareViewModel.removeDataListFood(myItems[index].name)
        } else {
            itemSelected.value = item.copy(isSelected = true)
            myItems[index] = item.copy(isSelected = true)
            shareViewModel.addDataListFood(myItems[index].name)
        }
    }

    Text(
        text = "Chọn Món Kèm Theo",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black.copy(alpha = 0.6f)
    )

    VerticalGrid(columns = 1, modifier = Modifier.padding(vertical = 12.dp)) {
        myItems.forEachIndexed { index, items ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .border(
                        width = 1.dp,
                        color = colorButtonChoose,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable {
                        toggleSelection(index)
                    }
                    .padding(10.dp)
            ) {
                Text(items.name, color = Black, fontSize = 15.sp)

                if (items.isSelected) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .background(bgMainWhile, CircleShape),
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        tint = colorButtonChoose,
                    )
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