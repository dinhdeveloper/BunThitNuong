package com.example.customer.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.customer.main.view.sign_in_up.IPPhoneScreen
import com.example.customer.main.view.sign_in_up.SignUpScreen
import com.example.customer.viewmodel.ShareViewModel

@Composable
fun NavigationLogin(
    navController: NavHostController,
) {
    val shareViewModel: ShareViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.InputPhoneNumber.route
    ) {
        composable(Screen.InputPhoneNumber.route) {
            IPPhoneScreen(navController, shareViewModel)
        }
        composable(Screen.SignUpScreen.route) {
            SignUpScreen(navController, shareViewModel)
        }


//        composable("${Screen.SignUpScreen.route}/{phoneNumber}",
//            arguments = listOf(navArgument("phoneNumber") { type = NavType.StringType })
//        ) { backStackEntry ->
//            backStackEntry.arguments?.getString("phoneNumber")?.let {
//                SignUpScreen(
//                    navController,
//                    phoneNumber = it
//                )
//            }
//        }
    }
}