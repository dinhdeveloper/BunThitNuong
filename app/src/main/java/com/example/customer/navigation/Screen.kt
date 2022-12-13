package com.example.customer.navigation

import com.example.customer.navigation.RouterNav.Companion.CARD_BAG_SCREEN
import com.example.customer.navigation.RouterNav.Companion.HOME_MAIN_SCREEN
import com.example.customer.navigation.RouterNav.Companion.PROCESS_ORDER_SRCEEN
import com.example.customer.navigation.RouterNav.Companion.NAVIGATION_DRAWER
import com.example.customer.navigation.RouterNav.Companion.INPUT_PHONE_NUMBER_SCREEN
import com.example.customer.navigation.RouterNav.Companion.SIGN_UP_SCREEN

sealed class Screen(val route: String) {
    //login
    object InputPhoneNumber : Screen(INPUT_PHONE_NUMBER_SCREEN)
    object SignUpScreen : Screen(SIGN_UP_SCREEN)

    //MAIN
    object Home : Screen(HOME_MAIN_SCREEN)
    object ProcessOrderScreen : Screen(PROCESS_ORDER_SRCEEN)
    object NavigationDrawer : Screen(NAVIGATION_DRAWER)
    object CartBagScreen : Screen(CARD_BAG_SCREEN)
}