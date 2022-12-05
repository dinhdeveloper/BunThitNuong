package com.example.thitnuong.ui.screen.home

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.thitnuong.common.DatePicker
import java.util.*


@Preview(showBackground = true)
@Composable
fun PreviewCustomTimeHomeScreen() {
    CustomTimeHomeScreen()
}


@Composable
fun CustomTimeHomeScreen() {
    var showWebView by remember { mutableStateOf(false) }
    val mDate = remember { mutableStateOf("") }

    Column {
        Text(
            text = "Chọn Thời Gian Giao ${mDate.value}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.6f),
            modifier = Modifier.clickable {
                showWebView = !showWebView
            }
        )
    }
    if(showWebView) {
        val mContext = LocalContext.current
        val mYear: Int
        val mMonth: Int
        val mDay: Int

        // Initializing a Calendar
        val mCalendar = Calendar.getInstance()

        // Fetching current year, month and day
        mYear = mCalendar.get(Calendar.YEAR)
        mMonth = mCalendar.get(Calendar.MONTH)
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

        mCalendar.time = Date()
        val mDatePickerDialog = DatePickerDialog(
            mContext,
            { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
            }, mYear, mMonth, mDay
        )
        mDatePickerDialog.show()
        showWebView = false
    }
}