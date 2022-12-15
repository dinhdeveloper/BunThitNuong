package com.example.customer.main.view.sign_in_up

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customer.common.otp_pin.LineOtpView
import com.example.customer.main.activity.MainActivity
import com.example.customer.ui.theme.Black
import com.example.customer.viewmodel.ShareViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(
    shareViewModel: ShareViewModel
) {
    val activity = (LocalContext.current as? Activity)

    val phoneNumber = shareViewModel.statePhoneNumber
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.padding(top = 70.dp, start = 30.dp, end = 30.dp)
    ) {
        Text(
            text = "Vui lòng nhập\nmã xác nhận cuả bạn",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start,
            fontSize = 28.sp,
            color = Black.copy(alpha = 0.9f)
        )

        Text(
            text = "Chúng tôi đã gửi mã đến số : $phoneNumber",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start,
            fontStyle = FontStyle.Italic,
            fontSize = 14.sp,
            color = Black.copy(alpha = 0.5f),
            modifier = Modifier.padding(top = 10.dp)
        )

        Row(Modifier.padding(top = 20.dp)) {
            LineOtpView(
                otpServer = "123456",
                handlerOTPSuccess = {
                    keyboardController?.hide()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                    activity?.finish()
                }
            )
        }
    }
}