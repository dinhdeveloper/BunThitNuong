package com.example.customer.common.otp_pin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.customer.ui.theme.bgOgran
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * OtpView is a composable function which is exposed to usage by external classes.
 * It will internally call private OtpView to draw the view
 *
 * @param modifier: Modifier that can be passed for configuration
 * @param otpStr: OTP text to be set on the view
 * @param numberOfFields: Number of pins to be needed in the otp
 * @param singlePinWidth: width of single pin
 * @param pinHeight: Height of otp view
 * @param isCursorEnabled: Is cursor needed to be displayed
 * @param defaultColor: Default color for the pin shape, when the pin is not focused
 * or filled.
 * @param focusColor: Color for shape outline when it is focused and not filled.
 * @param filledColor: Color for shape outline when it is filled with digit.
 * @param cursorColor: Color of the cursor
 * @param errorColor: Color for the pin outline when the otp entered is incorrect
 * @param isError: Boolean is true if the entered otp is incorrect
 * @param drawStyle: [DrawStyle] for the shape
 * @param shape: It is custom shapes created for the pins [PinShape]
 * @param textStyle: Style to be applied on text
 * @param onValueChange: Lambda to send changes in the text.
 */
@ExperimentalComposeUiApi
@Composable
fun OtpView(
    modifier: Modifier = Modifier,
    otpStr: String = "",
    numberOfFields: Int = 6,
    singlePinWidth: Dp = 50.dp,
    pinHeight: Dp = 50.dp,
    isCursorEnabled: Boolean = true,
    defaultColor: Color = Color.Gray,
    focusColor: Color = Color.Yellow,
    filledColor: Color = Color.Yellow,
    cursorColor: Color = Color.Yellow,
    errorColor: Color = bgOgran,
    isError: Boolean = false,
    drawStyle: DrawStyle = Stroke(width = 1f),
    shape: PinShape = PinShape.LineShape(1f),
    textStyle: androidx.compose.ui.text.TextStyle = androidx.compose.ui.text.TextStyle(
        color = Color.Black,
        fontSize = 20.sp,
    ),
    onValueChange: (String) -> Unit,
) {
    var isFocus by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current

    OtpView(
        modifier = modifier.height(height = pinHeight),
        singlePinWidth = singlePinWidth,
        text = otpStr,
        textStyle = textStyle,
        shape = shape,
        isFocus = isFocus,
        isCursorEnabled = isCursorEnabled,
        isError = isError,
        drawStyle = drawStyle,
        defaultColor = defaultColor,
        focusColor = focusColor,
        filledColor = filledColor,
        cursorColor = cursorColor,
        errorColor = errorColor,
        onValueChange = { value ->
            if (value.length <= numberOfFields) {
                onValueChange(value)
            }
        },
        onFocusChanged = {
            isFocus = it
        },
        onClick = {
            focusRequester.requestFocus()
            keyboard?.show()
        },
        numberOfFields = numberOfFields,
        focusRequester = focusRequester
    )
}

/**
 * Internal composable to draw the view.
 *
 * @param text: Text of the otp For eg: "123", "123456"
 * @param isError: Boolean which tells whether the otp entered is incorrect
 * @param isFocus: Whether the otp is currently focused
 * @param isCursorEnabled: To show the cursor or not
 * @param focusRequester: [FocusRequester] to control the focus of the TextField
 * @param onFocusChanged: Called when the focus of the TextField is changed
 * @param onClick: Called when otp view is clicked
 * @param onValueChange: Lambda for passing the value changes in the OTP
 *
 */
@ExperimentalComposeUiApi
@Composable
private fun OtpView(
    modifier: Modifier,
    numberOfFields: Int,
    singlePinWidth: Dp,
    text: String,
    textStyle: androidx.compose.ui.text.TextStyle,
    isError: Boolean,
    isFocus: Boolean,
    isCursorEnabled: Boolean,
    defaultColor: Color,
    focusColor: Color,
    filledColor: Color,
    cursorColor: Color,
    errorColor: Color,
    shape: PinShape,
    drawStyle: DrawStyle,
    focusRequester: FocusRequester,
    onFocusChanged: (hasFocus: Boolean) -> Unit,
    onClick: (index: Int) -> Unit,
    onValueChange: (String) -> Unit,
) {
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= numberOfFields && it.isDigitsOnly()) {
                    onValueChange(it)
                }
            },
            modifier = Modifier
                .size(0.dp)
                .focusRequester(focusRequester)
                .onFocusChanged {
                    onFocusChanged(it.isFocused)
                },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val nextFocusIndex = text.length
            for (i in 0 until numberOfFields) {
                PinField(
                    modifier = Modifier,
                    width = singlePinWidth,
                    digit = text.getOrNull(i)?.toString() ?: "",
                    textStyle = textStyle,
                    shape = shape,
                    isFocus = isFocus,
                    isFilled = text.getOrNull(i) != null,
                    isCurrentPinFocused = nextFocusIndex == i,
                    isCursorEnabled = isCursorEnabled,
                    isError = isError,
                    defaultColor = defaultColor,
                    focusColor = focusColor,
                    filledColor = filledColor,
                    cursorColor = cursorColor,
                    errorColor = errorColor,
                    drawStyle = drawStyle,
                    index = i,
                    onClick = onClick,
                )
            }
        }
    }
}

/**
 * It is composable for displaying an individual pin of the OtpView
 *
 * @param modifier: Modifier for the Pin
 * @param width: Width of the pin
 * @param index: index of the pin
 * @param digit: Digit in the particular pin
 * @param textStyle: Style to be applied on the digit
 */
@Composable
fun PinField(
    modifier: Modifier = Modifier,
    width: Dp,
    index: Int,
    digit: String,
    textStyle: androidx.compose.ui.text.TextStyle,
    isFocus: Boolean,
    isFilled: Boolean,
    isCurrentPinFocused: Boolean,
    isCursorEnabled: Boolean,
    isError: Boolean,
    defaultColor: Color,
    focusColor: Color,
    filledColor: Color,
    cursorColor: Color,
    errorColor: Color,
    shape: PinShape,
    drawStyle: DrawStyle,
    onClick: (index: Int) -> Unit,
) {
    var cursorSymbol by remember { mutableStateOf("") }

    if (isCursorEnabled && isFocus && isCurrentPinFocused && !isFilled) {
        LaunchedEffect(key1 = cursorSymbol, true) {
            launch {
                delay(500)
                cursorSymbol = if (cursorSymbol.isEmpty()) "|" else ""
            }
        }
    }
    Box(
        modifier = modifier
            .width(width)
            .fillMaxHeight()
            .drawBehind {
                drawPath(
                    path = shape.drawShape(this.size),
                    color = if (isError) errorColor else if (isFilled) filledColor else if (isFocus && isCurrentPinFocused) focusColor else defaultColor,
                    style = drawStyle
                )
            }
            .clickable {
                onClick(index)
            },
        contentAlignment = Alignment.Center
    ) {
        if (isCursorEnabled && digit == ""  && (isFocus && isCurrentPinFocused && !isFilled)) {
            Text(
                text = cursorSymbol,
                color = if (isError) errorColor else cursorColor,
                style = textStyle,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentSize()
            )
        }
        Text(
            text = digit,
            style = textStyle,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentSize()
        )
    }
}