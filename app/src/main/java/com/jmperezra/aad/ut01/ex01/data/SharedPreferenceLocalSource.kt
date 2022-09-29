package com.jmperezra.aad.ut01.ex01.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.aad.R
import com.jmperezra.aad.ut01.ex01.domain.Customer

class SharedPreferenceLocalSource(val context: Context) {

    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE
    )

    fun saveCustomer(customer: Customer) {
        val editor = sharedPref.edit()
        editor.apply {
            putInt("id", customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("is_active", customer.isActive)
            apply()
        }

        //Java Style
        /*editor.putInt("id", customer.id)
        editor.putString("name", customer.name)
        editor.putString("surname", customer.surname)
        editor.putBoolean("is_active", customer.isActive)
        editor.apply() // asíncrono
        //editor.commit() síncrono*/
    }

    fun getCustomer(): Customer {
        return Customer(
            sharedPref.getInt("id", 0),
            sharedPref.getString("name", "no existe") ?: "no exite",
            sharedPref.getString("surname", "no existe") ?: "no exite",
            sharedPref.getBoolean("is_active", true)
        )
    }
}