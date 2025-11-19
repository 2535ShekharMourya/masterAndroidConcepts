package com.example.masterandroidconcepts.dipendencyInjection.di.dagger2

import androidx.compose.animation.slideIn
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserRepositoryModule {
//    @Provides
//    fun getFirebaseRepository(): UserRepository {
//        return FirebaseRepository()
//    }
//    @Provides
//    fun getSqlRepository(sqlRepository: SqlRepository): UserRepository {
//        return sqlRepository
//    }

    @Binds
   abstract fun getSqlRepository(sqlRepository: SqlRepository): UserRepository
}