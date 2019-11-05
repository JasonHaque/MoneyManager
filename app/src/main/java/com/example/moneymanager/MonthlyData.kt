package com.example.moneymanager

import java.io.Serializable

data class MonthlyData(
    var monthname:String,
    var monthlyLimit:Int
):Serializable