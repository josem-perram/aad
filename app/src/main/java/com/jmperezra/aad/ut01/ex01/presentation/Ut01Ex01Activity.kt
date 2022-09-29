package com.jmperezra.aad.ut01.ex01.presentation

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jmperezra.aad.R
import com.jmperezra.aad.ut01.ex01.data.PreferenceLocalSource
import com.jmperezra.aad.ut01.ex01.data.SharedPreferenceLocalSource
import com.jmperezra.aad.ut01.ex01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        initSharedPreferences()
        initPreferences()
    }

    private fun initSharedPreferences(){
        //val spCustomer: SharedPreferenceLocalSource = SharedPreferenceLocalSource(this)
        val spCustomer = SharedPreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(2, "Customer2", "Surname2", true))

        ContextCompat.getColor(this, R.color.black)

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "CustomerShared: $newCustomer")
    }

    private fun initPreferences(){
        //val spCustomer: PreferenceLocalSource = SharedPreferenceLocalSource(this)
        val spCustomer = PreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(1, "Customer1", "Surname1", true))

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "CustomerActivity: $newCustomer")
    }

}