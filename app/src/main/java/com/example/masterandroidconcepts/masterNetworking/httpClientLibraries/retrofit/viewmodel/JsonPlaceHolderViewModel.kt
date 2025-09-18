package com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.api.RetrofitInstance
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.model.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JsonPlaceHolderViewModel:ViewModel() {
     val postsLiveData = MutableLiveData<PostResponse>()
    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val posts = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.getPosts()
                }
                // Update LiveData or StateFlow here
                if (posts.isSuccessful) {
                    postsLiveData.value = posts.body()
                }

            } catch (e: Exception) {
                e.printStackTrace()
                // Handle error
            }
        }
    }
}