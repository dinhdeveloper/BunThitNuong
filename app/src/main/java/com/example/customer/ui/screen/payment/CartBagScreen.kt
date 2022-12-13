package com.example.customer.ui.screen.payment

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.customer.ui.customview.ToolBarScreen
import com.example.customer.ui.theme.colorBg
import com.example.customer.viewmodel.ShareViewModel
import com.google.gson.Gson

@Composable
fun CartBagScreen(
    navController: NavController,
    shareViewModel : ShareViewModel
) {
    Log.e("SSSSSSSSSS","${Gson().toJson(shareViewModel.orderFoods)}")
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