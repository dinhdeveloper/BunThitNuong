package com.example.thitnuong.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dinhtc.android.thitnuong.R

@Composable
fun HomeScreen(
    navController: NavController
) {
    ConstraintLayout {

        val horizontalGuide25 = createGuidelineFromTop(0.25f)
        val horizontalGuide50 = createGuidelineFromTop(0.50f)
        val (
            imgBgMain,
            toolbarHome,
            titleHome,
            priceHome,
            bottomSheet,
            chooseFood,
            sizeFood,
            chooseTime,
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
        //bottomSheet
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//                .constrainAs(bottomSheet) {
//                    bottom.linkTo(parent.bottom)
//                    end.linkTo(parent.end)
//                    start.linkTo(parent.start)
//                }
//        ) {
//            CustomBottomSheetHomeScreen()
//        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .constrainAs(toolbarHome) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(20.dp)
        ) {
            CustomToolbarHomeScreen()
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .constrainAs(titleHome) {
                    top.linkTo(toolbarHome.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
                .padding(start = 20.dp, end = 20.dp, top = 10.dp)
        ) {
            CustomTitleHomeScreen()
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .constrainAs(priceHome) {
                    top.linkTo(titleHome.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
                .padding(start = 20.dp, end = 20.dp, top = 10.dp)
        ) {
            CustomPriceHomeScreen()
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .constrainAs(sizeFood) {
                    top.linkTo(priceHome.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
                .padding(start = 20.dp, end = 20.dp, top = 10.dp)
        ) {
            CustomSizeFoodHomeScreen()
        }


        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .constrainAs(chooseFood) {
                    top.linkTo(sizeFood.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 10.dp, end = 20.dp, top = 20.dp)
        ) {
            CustomFoodTogetherHomeScreen()
        }

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .constrainAs(chooseTime) {
                    top.linkTo(chooseFood.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 10.dp, end = 20.dp, top = 20.dp)
        ) {
            CustomTimeHomeScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}