package com.example.customer.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.customer.model.DatePickerModel
import com.example.customer.model.TimePickerModel
import com.example.customer.model.ViewOrderFoodModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShareViewModel @Inject constructor() : ViewModel() {

    var statePhoneNumber by mutableStateOf<String?>(null)
        private set

    fun addStatePhoneNumber(newPhone: String) {
        statePhoneNumber = newPhone
    }

    private val _dataListFood: MutableList<String> = mutableStateListOf()
    var dataListFood : MutableList<String> = _dataListFood

    fun addDataListFood(listFood: String){
        _dataListFood.add(listFood)
    }

    fun removeDataListFood(listFood: String){
        _dataListFood.remove(listFood)
    }

    private val _dataTimePicker = mutableStateOf<TimePickerModel?>(null)
    val dataTimePicker : MutableState<TimePickerModel?> =  _dataTimePicker

    fun setTimePicker(mHour: Int, mMinius: Int, mTimeSet: String) {
        _dataTimePicker.value = TimePickerModel(mHour,mMinius, mTimeSet = mTimeSet)
    }


    private val _dataDatePicker= mutableStateOf<DatePickerModel?>(null)
    val dataDatePicker : MutableState<DatePickerModel?> = _dataDatePicker

    fun setDatePicker(mYear: Int, mMonth: Int, mDay: Int) {
        _dataDatePicker.value = DatePickerModel(mYear,mMonth,mDay = mDay)
    }

    var orderFoods = mutableStateOf<ViewOrderFoodModel?>(null)

    fun shareOrderFood(orderFood: ViewOrderFoodModel) {
        orderFoods.value = orderFood
    }

}