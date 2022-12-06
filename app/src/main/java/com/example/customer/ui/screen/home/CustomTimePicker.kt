package com.example.customer.ui.screen.home

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customer.ui.theme.Black
import com.example.customer.ui.theme.bgMainWhile
import com.example.customer.ui.theme.colorButtonChoose

@Composable
fun CustomTimePicker(
    mHour: Int, mMinute: Int, mTimeSet: String
) {
    var showDiaLogTime by remember { mutableStateOf(false) }
    val sHour = remember { mutableStateOf("$mHour") }
    val sMinute = remember { mutableStateOf("$mMinute") }
    val timeSet = remember { mutableStateOf("$mTimeSet") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(bgMainWhile)
            .padding(end = 5.dp)
            .fillMaxWidth()
            .height(50.dp)
            .border(
                1.dp,
                colorButtonChoose,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 5.dp)
            .clickable {
                showDiaLogTime = true
            }
    ) {
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {

                Text(
                    text = sHour.value,
                    fontSize = 16.sp,
                    color = Black
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
            ) {
                Text(
                    text = ":",
                    textAlign = TextAlign.Center
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {

                Text(
                    text = sMinute.value,
                    fontSize = 16.sp,
                    color = Black
                )

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
            ) {
                Text(
                    text = ":",
                    textAlign = TextAlign.Center
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {

                Text(
                    text = timeSet.value,
                    fontSize = 16.sp,
                    color = Black
                )

            }

        }
    }

    if (showDiaLogTime) {
        val mContext = LocalContext.current
        val mTimePickerDialog = TimePickerDialog(
            mContext, { timePicker: TimePicker, mHour: Int, mMinute: Int ->
                sHour.value = "$mHour"
                sMinute.value = "$mMinute"

                if (timePicker.hour < 12) {
                    timeSet.value = "AM"
                } else {
                    timeSet.value = "PM"
                }

            }, mHour, mMinute, false
        )

        mTimePickerDialog.show()
        showDiaLogTime = false
    }
}