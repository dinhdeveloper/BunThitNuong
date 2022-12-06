package com.example.customer.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.customer.ui.theme.*
import dinhtc.android.customer.R

@Preview(showBackground = true)
@Composable
fun PreviewNavigationDrawer() {
    NavigationDrawer(
        navController = rememberNavController()
    )
}

@Composable
fun NavigationDrawer(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorToolbar)
            .fillMaxHeight()
            .padding(top = 20.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.img_icon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}