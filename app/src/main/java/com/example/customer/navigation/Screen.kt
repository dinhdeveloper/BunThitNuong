package com.example.customer.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object ProcessOrderScreen : Screen("process_order")
    object NavigationDrawer : Screen("navigation_drawer")



    //login
    object InputPhoneNumber : Screen("input_phone")
    object SignUpScreen : Screen("sign_up_screen")
}