package com.example.moneymanager

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserData  (
    val occupation : String="",
    val salary : Int,
    val address : String=""
):Serializable