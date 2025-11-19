package com.example.masterandroidconcepts.dipendencyInjection.di.withoutdi

import android.util.Log

class WithoutDiEmailService {
    fun send(to: String, from: String, body: String?) {
        Log.d("DI", "Email Sent")
    }
}