package com.example.customer.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customer.viewmodel.ShareViewModel
import java.util.*


@Preview(showBackground = true)
@Composable
fun PreviewCustomTimeHomeScreen() {

}

@Composable
fun CustomTimeHomeScreen(
    shareViewModel: ShareViewModel
) {

    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mHour: Int
    val mMinius: Int
    var mTimeSet = ""

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mHour = mCalendar.get(Calendar.HOUR_OF_DAY)
    mMinius = mCalendar.get(Calendar.MINUTE)

    if (mCalendar.get(Calendar.AM_PM) == Calendar.AM)
        mTimeSet = "AM"
    else if (mCalendar.get(Calendar.AM_PM) == Calendar.PM)
        mTimeSet = "PM"


    Column {
        Text(
            text = "Chọn Thời Gian Giao",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.6f)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            //time
            Column(Modifier.weight(1f)) {
                CustomTimePicker(mHour, mMinius, mTimeSet,shareViewModel)
            }
            //date
            Column(Modifier.weight(1f)) {
                CustomDatePicker(mYear, mMonth, mDay,shareViewModel)
            }

        }

    }
}
