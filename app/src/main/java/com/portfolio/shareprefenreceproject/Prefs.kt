package com.portfolio.shareprefenreceproject

import android.content.Context

class Prefs(context: Context) {

    val SHARED_NAME = "myDB"
    val SHARED_USERNAME = "userName"
    val SHARED_VIP = "vip"


    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveName(name: String) = storage.edit().putString(SHARED_USERNAME, name).apply()

    fun saveVIP(vip: Boolean) = storage.edit().putBoolean(SHARED_VIP, vip).apply()

    fun getName(): String = storage.getString(SHARED_USERNAME, "")!!

    fun getVIP(): Boolean = storage.getBoolean(SHARED_VIP, false)

    fun wipe() = storage.edit().clear().apply()

}