package com.example.customer.ui.screen.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customer.ui.customview.ToolBarScreen
import com.example.customer.ui.theme.*
import com.example.customer.viewmodel.ShareViewModel
import dinhtc.android.customer.R

@Composable
fun CartBagScreen(
    navController: NavController,
    shareViewModel: ShareViewModel
) {
    Column(
        modifier = Modifier
            .background(colorBg)
            .fillMaxSize()
    ) {
        ToolBarScreen(
            textToolbar = "Giỏ Hàng",
            onBack = {
                navController.popBackStack()
            }
        )
        CusTomViewCart(shareViewModel)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CusTomViewCartPreview() {
    CusTomViewCart(shareViewModel = hiltViewModel())
}

@Composable
fun CusTomViewCart(shareViewModel: ShareViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val horizontalGuide = createGuidelineFromTop(0.65f)
            val horizontalGuide2 = createGuidelineFromBottom(0.35f)
            val (
                imgProduct,
                viewBottom
            ) = createRefs()

            Card(
                modifier = Modifier
                    .constrainAs(viewBottom) {
                        bottom.linkTo(horizontalGuide2)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(horizontalGuide)
                    }
                    .padding(20.dp)
                    .height(300.dp)
                    .fillMaxSize()
                    .padding(bottom = 20.dp),
                elevation = 10.dp,
                backgroundColor = colorButton2
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    Text(
                        text = "Bún Thịt Nướng",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Row(
                        Modifier.padding(vertical = 5.dp)
                    ) {
                        Text(
                            text = "${shareViewModel.orderFoods?.statusFoodSize}:",
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "${shareViewModel.orderFoods?.countAll} phần",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        Modifier.padding(vertical = 5.dp)
                    ) {
                        Text(
                            text = "Ngày Giao:",
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "${shareViewModel.orderFoods?.datePicker}",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        Modifier.padding(vertical = 5.dp)
                    ) {
                        Text(
                            text = "Thời Gian Giao:",
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "${shareViewModel.orderFoods?.timePicker}",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    if (shareViewModel.orderFoods?.listFood?.size!! > 0){
                        Row(
                            Modifier.padding(vertical = 5.dp)
                        ) {
                            Text(
                                text = "Món Đi Kèm:",
                                modifier = Modifier.weight(1f)
                            )
                            Column {
                                for (data in shareViewModel.orderFoods?.listFood!!){
                                    Text(
                                        text = "- $data"
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Image(
                painter = painterResource(id = R.drawable.img_icon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(bottom = 55.dp)
                    .size(200.dp)
                    .clip(CircleShape)
                    .constrainAs(imgProduct) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(viewBottom.top)
                    }
            )
        }
    }
}
