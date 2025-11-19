package com.example.masterandroidconcepts.dipendencyInjection.di.dagger2

import android.util.Log
import javax.inject.Inject
interface UserRepository {
    fun saveUser(email: String, password: String)
}
class SqlRepository @Inject constructor(): UserRepository{
    override fun saveUser(email: String, password: String) {
        Log.d("DI", "User saved in Sql database: $email, $password")
    }
}

class FirebaseRepository: UserRepository{
    override fun saveUser(email: String, password: String) {
        Log.d("DI", "User saved in firebase: $email, $password")
    }
}