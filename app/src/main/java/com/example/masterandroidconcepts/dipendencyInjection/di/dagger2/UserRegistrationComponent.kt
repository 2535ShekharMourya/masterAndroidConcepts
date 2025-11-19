package com.example.masterandroidconcepts.dipendencyInjection.di.dagger2

import com.example.masterandroidconcepts.dipendencyInjection.di.DiActivity
import dagger.Component

@Component(modules = [NotificationServiceModule::class,UserRepositoryModule::class],)
interface UserRegistrationComponent {
    // 1st method Constructor Injection , this is not very good if we need 100 object then 100 method required so 2nd is good
    fun getUserRegistrationService():UserRegistrationService
    fun getEmailService():EmailService

    // 2nd method Field Injection, pass consumer here
    // this is good but we need to make all variable public and make it open
    // and we need to make sure that we need to call inject method in activity
    fun inject(diActivity: DiActivity)
}