package com.example.thitnuong.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.thitnuong.ui.theme.bgProduct
import com.example.thitnuong.ui.theme.bgTransient
import com.example.thitnuong.ui.theme.colorButton
import com.example.thitnuong.ui.theme.colorToolbar
import dinhtc.android.thitnuong.R


@Preview(showBackground = true)
@Composable
fun PreviewCustomFoodTogetherHomeScreen() {
    CustomFoodTogetherHomeScreen()
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
        items(10) {
            FoodTogetherItem()
        }
    }
}

@Composable
fun FoodTogetherItem() {
    ConstraintLayout(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .padding(horizontal = 10.dp)
            .background(bgTransient)
            .padding(vertical = 20.dp)
    ) {
        val horizontalGuideline25 = createGuidelineFromTop(0.30f)
        val horizontalGuideline75 = createGuidelineFromTop(0.65f)
        val (itemProduct, imvProduct, textProduct, textPrice) = createRefs()
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
                text = "Nước Mắm Cay",
                fontSize = 12.sp,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(textProduct) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(10.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.gia_song), contentDescription = null,
            modifier = Modifier.constrainAs(imvProduct) {
                bottom.linkTo(horizontalGuideline75)
                end.linkTo(parent.end)
            }
        )
    }
}
