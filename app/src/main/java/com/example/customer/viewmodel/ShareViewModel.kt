package com.example.customer.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShareViewModel @Inject constructor() : ViewModel() {

    var statePhoneNumber by mutableStateOf<String?>(null)
        private set

    fun addStatePhoneNumber(newPhone : String){
        statePhoneNumber = newPhone
    }
}