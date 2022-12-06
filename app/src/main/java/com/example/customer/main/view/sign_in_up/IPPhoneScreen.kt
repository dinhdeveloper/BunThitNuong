package com.example.customer.main.view.sign_in_up

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.customer.navigation.Screen
import com.example.customer.ui.theme.Black
import com.example.customer.ui.theme.bgMainWhile
import com.example.customer.ui.theme.bgOgran
import com.example.customer.ui.theme.colorToolbar
import com.example.customer.viewmodel.ShareViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun IPPhoneScreen(
    navController: NavController,
    shareViewModel: ShareViewModel
) {
    val activity = (LocalContext.current as? Activity)
    val keyboardController = LocalSoftwareKeyboardController.current
    var showWebView by remember { mutableStateOf(false) }
    var colorT by remember { mutableStateOf(colorToolbar) }
    var textState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(top = 70.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = "Vui lòng nhập\nsố điện thoại cuả bạn",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start,
            fontSize = 28.sp,
            color = Black.copy(alpha = 0.9f)
        )

        Text(
            text = "Chúng tôi sẽ gửi cho bạn một mã xác nhận",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start,
            fontStyle = FontStyle.Italic,
            fontSize = 14.sp,
            color = Black.copy(alpha = 0.5f),
            modifier = Modifier.padding(top = 10.dp)
        )

        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
        ) {
            val maxLength = 10
            val lightBlue = Color(0xffd8e6ff)

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        BorderStroke(width = 1.dp, color = colorT),
                        shape = RoundedCornerShape(8.dp)
                    ),
                value = textState,
                textStyle = TextStyle.Default.copy(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = bgMainWhile,
                    trailingIconColor = colorT,
                    cursorColor = Color.Black,
                    disabledLabelColor = lightBlue,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                onValueChange = {
                    if (it.length <= maxLength) {
                        textState = it
                        colorT = colorToolbar
                    }
                },
                singleLine = true,
                trailingIcon = {
                    if (textState.isNotEmpty()) {
                        IconButton(onClick = {
                            textState = ""
                            colorT = colorToolbar
                        }) {
                            Icon(
                                imageVector = Icons.Outlined.Close,
                                contentDescription = null
                            )
                        }
                    }
                },
                keyboardActions = KeyboardActions(onDone = {
                    if (textState == "0975469232") {
                        keyboardController?.hide()
                        colorT = colorToolbar
                        //INPUT OTP
                        showWebView = true
                    } else {
                        colorT = bgOgran
                    }
                }),
            )
            Text(
                text = "${textState.length} / $maxLength",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                textAlign = TextAlign.End,
                color = Black
            )
        }
        if (showWebView) {
            showWebView = false
            shareViewModel.addStatePhoneNumber(textState)
            navController.navigate(Screen.SignUpScreen.route)
        }
    }
}