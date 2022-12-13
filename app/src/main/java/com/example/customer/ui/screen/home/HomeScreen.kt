package com.example.customer.ui.screen.home

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.customer.model.FoodChooseModel
import com.example.customer.model.FoodOtherModel
import com.example.customer.model.ViewOrderFoodModel
import com.example.customer.navigation.Screen
import com.example.customer.ui.theme.bgOgran
import com.example.customer.viewmodel.ShareViewModel
import com.google.gson.Gson
import dinhtc.android.customer.R

@Composable
fun HomeScreen(
    navController: NavController,
    shareViewModel: ShareViewModel
) {
    var textCountAll by remember { mutableStateOf(1) }
    var textMoneySize by remember { mutableStateOf(30000) }
    var statusFoodSize by remember { mutableStateOf("Phần Nhỏ") }
    val foodOtherChoose = remember { mutableStateListOf<FoodChooseModel?>(null) }

    ConstraintLayout {
        val horizontalGuide25 = createGuidelineFromTop(0.25f)
        val (
            imgBgMain
        ) = createRefs()

        //background
        Image(
            painter = painterResource(id = R.drawable.ic_imv_bg_main),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(imgBgMain) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(horizontalGuide25)
                }
                .fillMaxSize()
        )
        LazyColumn {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    CustomToolbarHomeScreen(
                        onClickMenu = {
//                    NavigationDrawer(navController)
                        },
                        onClickProcessOrder = {
                            navController.navigate(Screen.ProcessOrderScreen.route)
                        }
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                        .fillMaxWidth()
                ) {
                    CustomTitleHomeScreen()
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier

                        .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                        .fillMaxWidth()
                ) {
                    CustomPriceHomeScreen(
                        textMoneySize,
                        onClickMinus = {
                            textCountAll = it
                        },
                        onClickPlus = {
                            textCountAll = it
                        }
                    )

                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                        .fillMaxWidth()
                ) {
                    CustomSizeFoodHomeScreen(
                        textCountAll,
                        setMoneySizeS = {
                            textMoneySize = it
                            statusFoodSize = "Phần Nhỏ"
                        },
                        setMoneySizeM = {
                            textMoneySize = it
                            statusFoodSize = "Phần Vừa"
                        },
                        setMoneySizeL = {
                            textMoneySize = it
                            statusFoodSize = "Phần Lớn"
                        }
                    )
                }


                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp, top = 20.dp)
                        .fillMaxWidth()
                ) {
                    CustomTimeHomeScreen(
                        shareViewModel
                    )
                }

                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                        .fillMaxWidth()

                ) {
                    CustomFoodOtherScreen(
                        foodOther,
                        shareViewModel
                    )
                }

                //thanh toan
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 20.dp)
                        .fillMaxWidth()

                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp)
                            .height(40.dp),
                        onClick = {
                            var timePicker =
                                "${shareViewModel.dataTimePicker.value?.mHour}-${shareViewModel.dataTimePicker.value?.mMinius}-${shareViewModel.dataTimePicker.value?.mTimeSet}"

                            var datePicker =
                                "${shareViewModel.dataDatePicker.value?.mDay}-${shareViewModel.dataDatePicker.value?.mMonth}-${shareViewModel.dataDatePicker.value?.mYear}"
                            var orderFood = ViewOrderFoodModel(
                                statusFoodSize,
                                textCountAll,
                                textMoneySize * textCountAll,
                                shareViewModel.dataListFood,
                                timePicker,
                                datePicker
                            )

                            shareViewModel.shareOrderFood(orderFood)
                            navController.navigate(Screen.CartBagScreen.route)
                        },
                        border = BorderStroke(1.dp, bgOgran),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                    ) {
                        Text(
                            text = "Thanh Toán",
                            color = bgOgran,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController(), ShareViewModel())
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun PreviewHomeScreen1() {
    HomeScreen(navController = rememberNavController(), ShareViewModel())
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun PreviewHomeScreen2() {
    HomeScreen(navController = rememberNavController(), ShareViewModel())
}


val foodOther = listOf(
    FoodOtherModel(1, "Nước Mắm Cay"),
    FoodOtherModel(2, "Nước Mắm Thường"),
    FoodOtherModel(3, "Giá Sống"),
    FoodOtherModel(4, "Giá Trụng"),
    FoodOtherModel(5, "Rau Đầy Đủ"),
    FoodOtherModel(6, "Không Rau")
)