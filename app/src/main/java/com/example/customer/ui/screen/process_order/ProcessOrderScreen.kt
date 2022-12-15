package com.example.customer.ui.screen.process_order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.customer.ui.customview.ToolBarScreen
import com.example.customer.ui.theme.colorBg

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProcessOrderScreenPreview() {
    ProcessOrderScreen(rememberNavController())
}

@Composable
fun ProcessOrderScreen(
    navController: NavController
) {
    LazyColumn(modifier = Modifier.background(colorBg).fillMaxSize()) {
        item {
            ToolBarScreen(
                textToolbar = "Thông Tin Đơn Hàng",
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}