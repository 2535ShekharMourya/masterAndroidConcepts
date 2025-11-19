package com.example.masterandroidconcepts.dipendencyInjection.di.withoutdi

class WithoutDiUserRegistrationService {
    // Problems with this approach
    // 1. Difficult to write unit tests.
    // 2. single responsibility
    // 3. lifetime of these objects
    // 1. Tight coupling between UserRegistrationService, UserRepository, and EmailService.
    // 2. Difficult to test UserRegistrationService in isolation.
    // 3. Changes in UserRepository or EmailService might require changes in UserRegistrationService.
    // 4. Difficult to reuse UserRegistrationService with different implementations of UserRepository or EmailService.
    // 5. Difficult to extend UserRegistrationService with new functionality.
    // 6. Difficult to understand the code at a glance.
    // 7. Difficult to maintain the code.
    // 8. Difficult to debug the code.
    // 9. Difficult to refactor the code.
    // 10. Difficult to write clean code.
    private val userRepository: WithoutDiUserRepository = WithoutDiUserRepository()
    private val emailService: WithoutDiEmailService = WithoutDiEmailService()

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "Registration", "You've been successfully registered!")
    }
}