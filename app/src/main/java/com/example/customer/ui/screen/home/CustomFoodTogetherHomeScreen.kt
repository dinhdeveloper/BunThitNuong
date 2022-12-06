package com.example.customer.ui.screen.home

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.customer.ui.theme.bgTransient
import com.example.customer.ui.theme.colorButton
import dinhtc.android.customer.R


@Preview(showBackground = true)
@Composable
fun PreviewCustomFoodTogetherHomeScreen() {
    CustomFoodTogetherHomeScreen()
}

@Preview(showBackground = true)
@Composable
fun PreviewShowImageChoose() {
    ShowImageChoose()
}


@Composable
fun CustomFoodTogetherHomeScreen() {
    Column {
        Text(
            text = "Chọn Món Kèm Theo",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.6f)
        )

    }
    LazyRow {
        items(listFoodTogether.size) {
            FoodTogetherItem(listFoodTogether[it])
        }
    }
}

@Composable
fun FoodTogetherItem(
    foodTogether: FoodTogerTher
) {
    var showWebView by remember { mutableStateOf(false) }

    ConstraintLayout(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .padding(horizontal = 10.dp)
            .background(bgTransient)
            .padding(vertical = 20.dp)
            .clickable {
                showWebView = true
            }
    ) {
        val horizontalGuideline25 = createGuidelineFromTop(0.30f)
        val horizontalGuideline75 = createGuidelineFromTop(0.65f)
        val (itemProduct, imvProduct, textProduct) = createRefs()
        ConstraintLayout(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .background(colorButton)
                .constrainAs(itemProduct) {
                    top.linkTo(horizontalGuideline25)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text(
                text = foodTogether.foodName,
                fontSize = 12.sp,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(textProduct) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(7.dp)
            )
        }

        Image(
            painter = painterResource(id = foodTogether.imageFood), contentDescription = null,
            modifier = Modifier.constrainAs(imvProduct) {
                bottom.linkTo(horizontalGuideline75)
                end.linkTo(parent.end)
            }
        )
    }
    if (showWebView) {
        showWebView = false
        ShowImageChoose()
    }
}

@Composable
fun ShowImageChoose() {
    ConstraintLayout(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .background(bgTransient)
    ) {
        val imvProduct = createRef()

        Image(
            painter = painterResource(id = R.drawable.ic_outline), contentDescription = null,
            modifier = Modifier.constrainAs(imvProduct) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )
    }
}

data class FoodTogerTher(var id: Int, var foodName: String, var imageFood: Int)

var listFoodTogether = listOf(
    FoodTogerTher(1, "Nước Mắm Cay", R.drawable.nuoc_mam),
    FoodTogerTher(2, "Nước Mắm Không Cay", R.drawable.nuoc_mam),
    FoodTogerTher(3, "Giá Trụng", R.drawable.gia_song),
    FoodTogerTher(4, "Giá Sống", R.drawable.gia_song),
)
