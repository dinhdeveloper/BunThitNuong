package com.example.customer.common.format

object FormatNumber {

    fun formatMoney(money: String?) : String {
        return "${Utils.formatMoney(Utils.formatDouble(money?.toDouble()))} VNĐ"
    }
}