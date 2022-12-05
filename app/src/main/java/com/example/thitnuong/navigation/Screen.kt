package com.example.thitnuong.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
}