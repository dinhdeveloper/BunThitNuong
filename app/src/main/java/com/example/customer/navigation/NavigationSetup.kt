package com.example.customer.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.customer.common.NavigationDrawer
import com.example.customer.ui.screen.home.HomeScreen
import com.example.customer.ui.screen.payment.CartBagScreen
import com.example.customer.ui.screen.process_order.ProcessOrderScreen
import com.example.customer.viewmodel.ShareViewModel

@Composable
fun NavigationSetup(
    navController: NavHostController,
) {
    val shareViewModel: ShareViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route) {
            HomeScreen(navController,shareViewModel)
        }

        composable(Screen.ProcessOrderScreen.route) {
            ProcessOrderScreen(navController)
        }

        composable(Screen.NavigationDrawer.route) {
            NavigationDrawer(navController)
        }

        composable(Screen.CartBagScreen.route) {
            CartBagScreen(navController)
        }
    }
}