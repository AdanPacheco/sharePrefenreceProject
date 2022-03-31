package com.portfolio.shareprefenreceproject

import android.app.Application

class SharedPreferenceApplication : Application() {

    companion object{
        lateinit var prefs:Prefs
    }

    override fun onCreate() {
        super.onCreate()
         prefs = Prefs(applicationContext)
    }
}