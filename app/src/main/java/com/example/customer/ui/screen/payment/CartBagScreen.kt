package com.example.customer.ui.screen.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.customer.ui.customview.ToolBarScreen
import com.example.customer.ui.theme.colorBg

@Composable
fun CartBagScreen(
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier.background(colorBg).fillMaxSize()
    ) {
        item {
            ToolBarScreen(
                textToolbar = "Giỏ Hàng"
            )
        }
    }
}