package com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.DataItem
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.Resource
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.repository.RVRepository
import kotlinx.coroutines.launch

class RVViewModel(private val repository: RVRepository): ViewModel() {
    private val _homepageData = MutableLiveData<Resource<List<DataItem>>>()
    val homepageData: MutableLiveData<Resource<List<DataItem>>> get() = _homepageData
    fun getHomePageData(){
        viewModelScope.launch {
            _homepageData.value = Resource.Loading
            _homepageData.value = repository.getHomePageData()
        }

    }

}