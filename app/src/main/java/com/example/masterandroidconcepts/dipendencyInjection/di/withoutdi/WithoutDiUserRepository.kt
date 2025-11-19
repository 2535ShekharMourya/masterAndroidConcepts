package com.example.masterandroidconcepts.dipendencyInjection.di.withoutdi

import android.util.Log

class WithoutDiUserRepository {
    fun saveUser(email: String, password: String) {
        Log.d("DI", "User saved in database")
    }
}