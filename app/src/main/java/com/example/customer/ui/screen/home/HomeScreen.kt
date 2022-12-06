package com.example.customer.ui.screen.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.customer.common.NavigationDrawer
import com.example.customer.navigation.Screen
import dinhtc.android.customer.R

@Composable
fun HomeScreen(
    navController: NavController
) {
    val mContext = LocalContext.current

    var textCountAll by remember { mutableStateOf(1) }
    var textMoneySize by remember { mutableStateOf(30000) }

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
        LazyColumn{
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
                        })
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
                        },
                        setMoneySizeM = {
                            textMoneySize = it
                        },
                        setMoneySizeL = {
                            textMoneySize = it
                        }
                    )
                }


                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp, top = 20.dp)
                        .fillMaxWidth()
                ) {
                    //CustomFoodTogetherHomeScreen()
                    CustomTimeHomeScreen()
                }

                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                        .fillMaxWidth()

                ) {
                    CustomFoodOtherScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}