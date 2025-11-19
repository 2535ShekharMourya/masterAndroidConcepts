package com.example.masterandroidconcepts.dipendencyInjection.di.manualdi

import android.util.Log

class ManualDiUserRepository {
    fun saveUser(email: String, password: String) {
        Log.d("DI", "User saved in database")
    }
}