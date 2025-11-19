package com.example.masterandroidconcepts.dipendencyInjection.di.manualdi

import android.util.Log

class ManualDiEmailService {
    fun send(to: String, from: String, body: String?) {
        Log.d("DI", "Email Sent")
    }
}