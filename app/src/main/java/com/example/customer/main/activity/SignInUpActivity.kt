package com.example.customer.main.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.customer.main.view.sign_in_up.IPPhoneScreen
import com.example.customer.navigation.NavigationLogin
import com.example.customer.navigation.NavigationSetup
import com.example.customer.ui.theme.BunThitNuongTheme

class SignInUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BunThitNuongTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SignInMainScreen()
                }
            }
        }
    }
}

@Composable
fun SignInMainScreen(){
    val navController = rememberNavController()
    Scaffold(
        content = {
            NavigationLogin(
                navController = navController
            )
        }
    )
}