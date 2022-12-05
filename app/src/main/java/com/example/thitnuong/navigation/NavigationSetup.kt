package com.example.thitnuong.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thitnuong.ui.screen.home.HomeScreen

@Composable
fun NavigationSetup(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
    }
}