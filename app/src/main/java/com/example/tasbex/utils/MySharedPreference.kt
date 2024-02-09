package com.example.tasbex.utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreference {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences:SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var myCounter:Int
        get() = preferences.getInt("key",0)
        set(value) = preferences.edit {
            it.putInt("key",value)
        }

    var sanoq:Int
        get() = preferences.getInt("keysana",0)
        set(value) = preferences.edit {
            it.putInt("keysana",value)
        }
}