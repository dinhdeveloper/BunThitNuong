package com.example.customer.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ShareViewModel @Inject constructor() : ViewModel() {

    var statePhoneNumber by mutableStateOf<String?>(null)
        private set

    fun addStatePhoneNumber(newPhone: String) {
        statePhoneNumber = newPhone
    }

    val dataListFood: MutableList<String> = mutableStateListOf()
    fun addDataListFood(listFood: String){
        dataListFood.add(listFood)
    }

    fun removeDataListFood(listFood: String){
        dataListFood.remove(listFood)
    }

    private val _uiState = MutableStateFlow(String)
    val uiState: StateFlow<String.Companion> = _uiState.asStateFlow()
}