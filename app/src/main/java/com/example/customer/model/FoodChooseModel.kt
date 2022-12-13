package com.example.customer.model

data class FoodChooseModel(
    var id: Int,
    var name: String,
    var price: Int,
    var count: Int,
    var timeStart: String,
    var dateStart: String,
    var listFoodOther: List<String>
)