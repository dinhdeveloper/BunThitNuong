package com.example.thitnuong.main.view

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.thitnuong.navigation.NavigationSetup


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold{
        NavigationSetup(
            navController = navController,
        )
    }
}