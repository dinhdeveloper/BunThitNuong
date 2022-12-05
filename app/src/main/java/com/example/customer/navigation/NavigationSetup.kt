package com.example.customer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.customer.ui.screen.home.HomeScreen
import com.example.customer.ui.screen.process_order.ProcessOrderScreen

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

        composable(Screen.ProcessOrderScreen.route) {
            ProcessOrderScreen(navController)
        }


    }
}