package com.example.smt5k.common

import android.content.Context
import android.widget.Toast
import java.util.*

fun toast(context : Context, string :String) {
    Toast.makeText(context, string, Toast.LENGTH_LONG).show()
}

fun toast(context : Context, integer :Integer)  {
    Toast.makeText(context, integer.toString() , Toast.LENGTH_LONG).show()
}

fun toast(context : Context, boolean :Boolean)  {
    Toast.makeText(context, boolean.toString() , Toast.LENGTH_LONG).show()
}

fun toast(context : Context, double :Double)  {
    Toast.makeText(context, double.toString() , Toast.LENGTH_LONG).show()
}

fun toast(context : Context, data: Date)  {
    Toast.makeText(context, getNormalDateString(data), Toast.LENGTH_LONG).show()
}