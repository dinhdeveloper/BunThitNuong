package com.example.customer.ui.screen.payment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
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
                clearData(shareViewModel)
                navController.popBackStack()
            }
        )
        CusTomViewCart(shareViewModel)
    }
}

fun clearData(shareViewModel: ShareViewModel) {
    shareViewModel.orderFoods.value?.listFood = emptyList()
    for (data in shareViewModel.orderFoods.value?.listFood!!){
        shareViewModel.removeDataListFood(data)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CusTomViewCartPreview() {
    CusTomViewCart(shareViewModel = hiltViewModel())
}

@Composable
fun CusTomViewCart(shareViewModel: ShareViewModel) {
    var showDialog by remember { mutableStateOf(false) }
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
                    .height(400.dp)
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
                            text = "${shareViewModel.orderFoods.value?.statusFoodSize}:",
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "${shareViewModel.orderFoods.value?.countAll} phần",
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
                            text = "${shareViewModel.orderFoods.value?.datePicker}",
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
                            text = "${shareViewModel.orderFoods.value?.timePicker}",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    if (shareViewModel.orderFoods.value?.listFood?.isNotEmpty() == true){
                        Row(
                            Modifier.padding(vertical = 5.dp)
                        ) {
                            Text(
                                text = "Món Đi Kèm:",
                                modifier = Modifier.weight(1f)
                            )
                            Column(Modifier.padding(bottom = 20.dp)) {
                                for (data in shareViewModel.orderFoods.value?.listFood!!){
                                    Text(
                                        text = "- $data"
                                    )
                                }
                            }
                        }
                    }

                    Button(
                        onClick = {
                            showDialog = true
                        },
                        shape = RoundedCornerShape(35.dp),
                        border = BorderStroke(1.dp, Color.Red),
                        colors = ButtonDefaults.buttonColors(contentColor = Color.Red, backgroundColor = Color.White)
                    ) {
                        Text(
                            text = "Đặt Hàng",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(horizontal = 40.dp, vertical = 4.dp)
                        )
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
        if(showDialog){
            Dialog(onDismissRequest = { showDialog = false }, DialogProperties(
                dismissOnBackPress = false,dismissOnClickOutside = false
            )) {
                CircularProgressIndicator(
                    modifier = Modifier,
                    color = bgOgran,
                    strokeWidth = 2.dp
                )
            }
        }
    }
}

@Composable
fun RoundedCircularProgress(
    progress: Float,
    strokeWidth: Dp,
    progressColor: Color,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.size(100.dp)) {
        // circle progress
        CircularProgressIndicator(
            progress = progress,
            color = progressColor,
            strokeWidth = strokeWidth,
            modifier = Modifier.fillMaxSize()
        )
        // start circle
        Spacer(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.TopCenter)
            .size(strokeWidth)
            .background(progressColor, CircleShape)
        )
        // end circle
        Spacer(modifier = Modifier
            .fillMaxSize()
            .rotate(360 * progress)
            .wrapContentSize(align = Alignment.TopCenter)
            .size(strokeWidth)
            .background(progressColor, CircleShape)
        )
    }
}

@Composable
fun ShowLoading(){
    Box(
        modifier = Modifier.size(60.dp).background(bgTransient, shape = RoundedCornerShape(8.dp)),
        contentAlignment= Alignment.Center,
    ){
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = 0.45f,
                color = Red,
                modifier = Modifier.then(Modifier.size(20.dp)))
            CircularProgressIndicator(
                progress = 0.55f,
                color = Green,
                modifier = Modifier.then(Modifier.size(40.dp)))
            CircularProgressIndicator(
                progress = 0.75f,
                color = Blue,
                modifier = Modifier.then(Modifier.size(60.dp)))
        }
    }
}
