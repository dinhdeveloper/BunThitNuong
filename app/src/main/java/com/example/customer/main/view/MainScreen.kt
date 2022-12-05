package com.example.customer.main.view

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.customer.navigation.NavigationSetup


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold{
        NavigationSetup(
            navController = navController,
        )
    }
}