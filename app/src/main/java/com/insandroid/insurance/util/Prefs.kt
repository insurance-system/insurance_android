package com.insandroid.insurance.util

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val prefs : SharedPreferences = context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)
    private val editor : SharedPreferences.Editor = prefs.edit()

    fun getString(key: String, defValue: String): String {
        return prefs.getString(key, defValue).toString()
    }

    fun setString(key: String, str: String) {
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putString(key, str).apply()
    }

    fun setUserId(input: String){
        editor.putString("MY_ID", input)
        editor.commit()
    }

    fun setUserIdx(input: String){
        editor.putString("MY_IDX", input)
        editor.commit()
    }


    fun setUserPW(input: String){
        editor.putString("MY_PW", input)
        editor.commit()
    }

    fun getUserId():String{
        return prefs.getString("MY_ID", "").toString()
    }
    fun getUserPW():String{
        return prefs.getString("MY_PW", "").toString()
    }



    fun getUserIdx(): String {
        return prefs.getString("MY_IDX", "").toString()
    }

    fun clearUser(){
        editor.clear()
        editor.commit()
    }
}