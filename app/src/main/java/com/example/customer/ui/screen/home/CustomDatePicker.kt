package com.example.customer.ui.screen.home

import android.app.DatePickerDialog
import android.widget.DatePicker
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
import com.example.customer.viewmodel.ShareViewModel
import java.util.*

@Composable
fun CustomDatePicker(
    mYear: Int, mMonth: Int, mDay: Int,
    shareViewModel: ShareViewModel
) {
    var showDiaLogDate by remember { mutableStateOf(false) }
    val sDate = remember { mutableStateOf("$mDay") }
    val sMouth = remember { mutableStateOf("$mMonth") }
    val sYear = remember { mutableStateOf("$mYear") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(bgMainWhile)
            .padding(start = 5.dp)
            .fillMaxWidth()
            .height(40.dp)
            .border(
                1.dp,
                colorButtonChoose,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 5.dp)
            .clickable {
                showDiaLogDate = true
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
                    text = sDate.value,
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
                    text = "-",
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
                    text = sMouth.value,
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
                    text = "-",
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
                    text = sYear.value,
                    fontSize = 16.sp,
                    color = Black
                )

            }

        }
    }

    if (showDiaLogDate) {
        val mContext = LocalContext.current
        val mCalendar = Calendar.getInstance()
        mCalendar.time = Date()
        val mDatePickerDialog = DatePickerDialog(
            mContext,
            { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                //mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
                sDate.value = "$mDayOfMonth"
                sMouth.value = "$mMonth"
                sYear.value = "$mYear"
                shareViewModel.setDatePicker(mYear, mMonth, mDay)
            }, mYear, mMonth, mDay
        )
        mDatePickerDialog.datePicker.minDate = mCalendar.timeInMillis
        mDatePickerDialog.show()
        showDiaLogDate = false
    }
}