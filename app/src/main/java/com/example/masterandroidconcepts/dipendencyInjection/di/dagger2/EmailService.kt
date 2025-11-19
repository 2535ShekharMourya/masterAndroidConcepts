package com.example.masterandroidconcepts.dipendencyInjection.di.dagger2

import android.util.Log
import jakarta.inject.Inject
interface NotificationService {
    fun send(to: String, from: String, body: String?)
}
class EmailService @Inject constructor(): NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d("DI", "Email Sent to $to from $from body $body")
    }
}

class MessageService: NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d("DI", "Message Sent to $to from $from body $body")
    }
}