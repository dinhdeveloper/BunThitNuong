package com.example.customer.main.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.customer.common.NavigationDrawer
import com.example.customer.navigation.NavigationSetup
import com.example.customer.ui.theme.colorBgCam
import com.example.customer.ui.theme.colorButton2
import com.example.customer.ui.theme.colorButtonChoose


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val floatingActionSelected = remember {
        mutableStateOf(false)
    }
    Scaffold(
//        content = {
//            NavigationSetup(
//                navController = navController
//            )
//        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {floatingActionSelected.value = ! floatingActionSelected.value},
                backgroundColor = if (floatingActionSelected.value) colorButtonChoose else Color.White
            ) {
                Icon(
                    Icons.Filled.ShoppingCart,
                    tint = if (floatingActionSelected.value) Color.White else colorBgCam,
                    contentDescription = null
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,

        bottomBar = {
            BottomAppBarComponent()
        }
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = it.calculateBottomPadding() + 10.dp
                )
            //.padding(it) // <<-- or simply this
        ) {
            NavigationSetup(
                navController = navController
            )
        }
    }
}


@Composable
private fun BottomAppBarComponent() {
    val selectedHome = remember {
        mutableStateOf(true)
    }
    val selectedSearch = remember {
        mutableStateOf(false)
    }
    val selectedNotifications = remember {
        mutableStateOf(false)
    }
    val selectedPerson = remember {
        mutableStateOf(false)
    }

    BottomAppBar(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = colorButtonChoose,
        elevation = 5.dp,
        cutoutShape = CircleShape
    ) {

        // Leading icons should typically have a high content alpha
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            IconButton(onClick = {
                selectedHome.value = true
                selectedSearch.value = false
                selectedNotifications.value = false
                selectedPerson.value = false
            }) {
                Icon(Icons.Filled.Home, contentDescription = null,
                    tint = if (selectedHome.value) colorButtonChoose else colorBgCam)
            }
        }
        Spacer(modifier = Modifier.weight(2f))
        IconButton(onClick = {
            selectedHome.value = false
            selectedSearch.value = true
            selectedNotifications.value = false
            selectedPerson.value = false
        }) {
            Icon(Icons.Filled.Search, contentDescription = null,
                tint = if (selectedSearch.value) colorButtonChoose else colorBgCam)
        }
        Spacer(modifier = Modifier.weight(6f))
        IconButton(onClick = {
            selectedHome.value = false
            selectedSearch.value = false
            selectedNotifications.value = true
            selectedPerson.value = false
        }) {
            Icon(Icons.Filled.Notifications, contentDescription = null,
                tint = if (selectedNotifications.value) colorButtonChoose else colorBgCam)
        }
        Spacer(modifier = Modifier.weight(2f))
        IconButton(onClick = {
            selectedHome.value = false
            selectedSearch.value = false
            selectedNotifications.value = false
            selectedPerson.value = true
        }) {
            Icon(Icons.Filled.Person, contentDescription = null,
                tint = if (selectedPerson.value) colorButtonChoose else colorBgCam)
        }
    }
}
