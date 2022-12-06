package com.example.customer.common.otp_pin

import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.customer.ui.theme.colorToolbar

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LineOtpView(
    shape: PinShape = PinShape.LineShape(5f),
    otpServer: String?,
    handlerOTPSuccess: () -> Unit
) {
    var otpStr by remember {
        mutableStateOf("")
    }
    var isError by remember {
        mutableStateOf(false)
    }
    OtpView(
        otpStr = otpStr,
        isError = isError,
        filledColor = colorToolbar,
        focusColor = Color.Black,
        cursorColor = colorToolbar,
        shape = shape,
        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 22.sp)
    ) { otpClient ->
        otpStr = otpClient
        if (otpStr.length == 6) {
            // Completely filled
            isError = otpStr != otpServer
            if (isError) {
                otpStr = ""
            } else {
                handlerOTPSuccess()
            }
        }
        if (isError && otpStr.isNotEmpty()) {
            isError = false
        }
    }
}