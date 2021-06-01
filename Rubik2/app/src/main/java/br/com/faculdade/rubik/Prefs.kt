package br.com.faculdade.rubik

import android.content.SharedPreferences

object Prefs {

    private fun prefs(): SharedPreferences {
        val contexto = RubikApplication.get_instance().applicationContext
        return contexto.getSharedPreferences("Rubik_PREFS", 0)
    }

    fun setBoolean(flag: String, valor:Boolean) = prefs().edit().putBoolean(flag, valor).apply()

    fun setString(flag: String, valor: String) = prefs().edit().putString(flag, valor).apply()

    fun getBoolean(flag: String) = prefs().getBoolean(flag, false)

    fun getString(flag: String) = prefs().getString(flag, "")
}