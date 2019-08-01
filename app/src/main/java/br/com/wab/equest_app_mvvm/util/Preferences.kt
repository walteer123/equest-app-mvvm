package br.com.wab.equest_app_mvvm.util

import android.content.Context
import android.content.SharedPreferences

class Preferences {

   companion object {

       private fun get(context: Context): SharedPreferences {
           return context.getSharedPreferences("PREFS", Context.MODE_PRIVATE)
       }

       fun putString(context: Context, key: String, value: String) {
           val prefs = get(context)
           prefs.edit().putString(key, value).apply()
       }

       fun getString(context: Context, key: String, defaultValue: String): String{
           val prefs = get(context)
           return prefs.getString(key, defaultValue)!!
       }

   }

}