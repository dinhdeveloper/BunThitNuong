package com.example.customer.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object ProcessOrderScreen : Screen("process_order")
}