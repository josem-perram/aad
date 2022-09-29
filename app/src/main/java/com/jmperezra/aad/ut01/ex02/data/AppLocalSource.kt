package com.jmperezra.aad.ut01.ex02.data

import android.content.Context
import android.view.Display.Mode
import com.jmperezra.aad.R
import com.jmperezra.aad.ut01.ex01.data.SharedPreferenceLocalSource
import com.jmperezra.aad.ut01.ex02.domain.App

const val KEY_IS_FIRST_OPENED = "is_first_opened"

class AppLocalSource(private val context: Context) {

    private val localStorage = context.getSharedPreferences(
        context.getString(R.string.key_app),
        Context.MODE_PRIVATE
    )

    fun saveApp(app: App) {
        val edit = localStorage.edit()
        edit.putBoolean(KEY_IS_FIRST_OPENED, app.isFirstOpened)
        edit.apply()


        /*localStorage.edit().apply {
            putBoolean(KEY_IS_FIRST_OPENED, app.isFirstOpened)
            apply()
        }*/
    }

    fun getApp(): App {
        return App(
            localStorage.getBoolean(KEY_IS_FIRST_OPENED, true)
        )
    }

}