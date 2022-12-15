package com.example.customer.main.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.customer.navigation.NavigationSetup
import com.example.customer.ui.theme.BunThitNuongTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BunThitNuongTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        content = {
                            NavigationSetup(
                                navController = navController
                            )
                        })
                }
            }
        }
    }
}