package com.example.moneymanager

import java.io.Serializable


data class dailyData(
    var expenseName:String,
    var expenseAmount: Int
):Serializable