package com.example.masterandroidconcepts.dipendencyInjection.di

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.masterandroidconcepts.R
import com.example.masterandroidconcepts.dipendencyInjection.di.dagger2.DaggerUserRegistrationComponent
import com.example.masterandroidconcepts.dipendencyInjection.di.dagger2.EmailService
import com.example.masterandroidconcepts.dipendencyInjection.di.dagger2.UserRegistrationService
import com.example.masterandroidconcepts.dipendencyInjection.di.manualdi.ManualDiEmailService
import com.example.masterandroidconcepts.dipendencyInjection.di.manualdi.ManualDiUserRegistrationService
import com.example.masterandroidconcepts.dipendencyInjection.di.manualdi.ManualDiUserRepository
import com.example.masterandroidconcepts.dipendencyInjection.di.withoutdi.WithoutDiUserRegistrationService
import javax.inject.Inject

// dependencies is nothing but it is required objects for a class ex: UserRegistrationService(userRepository,emailService) it needs two objects everytime whenever created
class DiActivity : AppCompatActivity() {
    // this is called field injection
    @Inject
    lateinit var userRegistrationService: UserRegistrationService
    @Inject
    lateinit var emailService: EmailService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_di)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       val component = DaggerUserRegistrationComponent.builder().build()
        component.inject(this)
        userRegistrationService.registerUser("dagger2test@test.com", "1234")



    }
    fun withoutDi(){
        // 1st. Without Di
        val userRegistrationService1 = WithoutDiUserRegistrationService()
        userRegistrationService1.registerUser("withoutditest@test.com","1234")
    }
    fun manualDi(){
        // 2end.ManualDi: here also one more problem whenever we creating UserRegistrationService we need to create both object everytime so dagger2 solve this problems
        val emailService = ManualDiEmailService()
        val userRepository = ManualDiUserRepository()
        val userRegistrationService = ManualDiUserRegistrationService(userRepository,emailService)
        userRegistrationService.registerUser("manualditest@test.com","1234")
    }
    fun dagger2() {
        // 3rd. Dagger2
        // this is known constructor dependency
        //val userRegistrationService = DaggerUserRegistrationComponent.builder().build().getUserRegistrationService()
        val component = DaggerUserRegistrationComponent.builder().build()
        val userRegistrationService = component.getUserRegistrationService()
        val userEmailService = component.getEmailService()
        userRegistrationService.registerUser("dagger2test@test.com", "1234")
        userEmailService.send(
            "dagger2test@test.com",
            "Registration",
            "You've been successfully registered!"
        )
    }
}