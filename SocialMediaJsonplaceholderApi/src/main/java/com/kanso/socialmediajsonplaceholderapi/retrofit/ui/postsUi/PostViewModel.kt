package com.kanso.socialmediajsonplaceholderapi.retrofit.ui.postsUi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.api.RetrofitInstance
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.model.Resource
import com.kanso.socialmediajsonplaceholderapi.retrofit.model.posts.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel: ViewModel(){
    val postsLiveData = MutableLiveData<Resource<PostResponse>>()
    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val posts = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.getPosts()
                }
                // Update LiveData or StateFlow here
                when(posts){
                    is Resource.Loading -> {
                        postsLiveData.value = Resource.Loading
                    }
                    is Resource.Success -> {
                        postsLiveData.value = Resource.Success(posts.result)
                    }
                    is Resource.Failure -> {
                        postsLiveData.value = Resource.Failure(posts.exception)
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
                // Handle error
            }
        }
    }
}