package com.example.customer.ui.screen.home

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customer.ui.theme.*
import dinhtc.android.customer.R
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
            text = "Chọn Thời Gian Giao",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.6f),
            modifier = Modifier.clickable {
                showWebView = !showWebView
            }
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            //time
            Column(Modifier.weight(1f)) {
                CustomTimePicker()
            }
            //date
            Column(Modifier.weight(1f)) {
                CustomDatePicker()
            }

        }

    }
    if (showWebView) {
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
                mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
            }, mYear, mMonth, mDay
        )
        mDatePickerDialog.show()
        showWebView = false
    }
}

@Composable
fun CustomDatePicker() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(bgMainWhile)
            .padding(start = 5.dp)
            .fillMaxWidth()
            .height(70.dp)
            .border(
                1.dp,
                colorButtonChoose,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 5.dp)
    ) {
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f).fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_up),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )

                Text(
                    text = "09",
                    fontSize = 14.sp,
                    color = Black
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_down),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_up),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )

                Text(
                    text = "Feb",
                    fontSize = 14.sp,
                    color = Black
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_down),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_up),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )

                Text(
                    text = "2023",
                    fontSize = 14.sp,
                    color = Black
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_down),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )
            }

        }
    }
}

@Composable
fun CustomTimePicker() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(bgMainWhile)
            .padding(end = 5.dp)
            .fillMaxWidth()
            .height(70.dp)
            .border(
                1.dp,
                colorButtonChoose,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 5.dp)
    ) {
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f).fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_up),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )

                Text(
                    text = "09",
                    fontSize = 14.sp,
                    color = Black
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_down),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_up),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )

                Text(
                    text = "11",
                    fontSize = 14.sp,
                    color = Black
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_down),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_up),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )

                Text(
                    text = "AM",
                    fontSize = 14.sp,
                    color = Black
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_down),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp).weight(1f)
                )
            }

        }
    }
}
