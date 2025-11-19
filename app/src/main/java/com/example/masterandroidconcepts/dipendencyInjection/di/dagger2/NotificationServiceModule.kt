package com.example.masterandroidconcepts.dipendencyInjection.di.dagger2

import dagger.Module
import dagger.Provides

@Module
class NotificationServiceModule {
    @Provides
    fun getMessageService(): NotificationService {
        return MessageService()
    }
}