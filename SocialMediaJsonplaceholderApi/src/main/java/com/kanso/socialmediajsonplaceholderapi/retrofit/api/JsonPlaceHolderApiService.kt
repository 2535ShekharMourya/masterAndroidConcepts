package com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.api

import com.kanso.socialmediajsonplaceholderapi.retrofit.model.posts.PostResponse
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.model.PostResponseItem
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.model.Resource
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderApiService {
        @GET("posts")
        suspend fun getPosts(): Resource<PostResponse>

        @GET("posts/{id}")
        suspend fun getIndividualPost(@Path("id") id: Int): Resource<PostResponseItem>

}