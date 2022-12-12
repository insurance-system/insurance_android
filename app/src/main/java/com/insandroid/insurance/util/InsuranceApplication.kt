package com.insandroid.insurance.util

import android.app.Application
import android.content.Context

class InsuranceApplication : Application(){
    companion object{
        var appContext : Context? = null

        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}