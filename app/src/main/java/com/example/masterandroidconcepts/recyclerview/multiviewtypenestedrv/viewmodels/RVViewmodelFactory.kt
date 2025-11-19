package com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.repository.RVRepository

class RVViewmodelFactory(private val repo: RVRepository): ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Checks if the requested class is MinisHomeViewModel
        if (modelClass.isAssignableFrom(RVViewModel::class.java)) {
            // Returns a new instance, injecting the dependency
            return RVViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}