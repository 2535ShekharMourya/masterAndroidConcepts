package com.example.masterandroidconcepts.dipendencyInjection.di.dagger2
import javax.inject.Inject

class UserRegistrationService @Inject constructor(private val userRepository: UserRepository, private val notificationService: NotificationService){
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "Registration", "You've been successfully registered!")
    }
}