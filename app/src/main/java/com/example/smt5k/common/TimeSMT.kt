package com.example.smt5k.common

import java.text.SimpleDateFormat
import java.util.*

fun getNormalDateString(date : Date):String {
    val df = SimpleDateFormat("kk:mm:ss  dd-MM-yyyy")
    return df.format(date)
}
