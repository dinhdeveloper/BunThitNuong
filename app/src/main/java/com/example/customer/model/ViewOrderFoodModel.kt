package com.example.customer.model

data class ViewOrderFoodModel(

    var statusFoodSize: String,
    var countAll: Int,
    var moneyAll: Int,
    var listFood: List<String>,
    var timePicker: String,
    var datePicker: String,
)