package com.example.masterandroidconcepts.dipendencyInjection.di.manualdi

class ManualDiUserRegistrationService(private val userRepository: ManualDiUserRepository, private val emailService: ManualDiEmailService) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "Registration", "You've been successfully registered!")
    }
}