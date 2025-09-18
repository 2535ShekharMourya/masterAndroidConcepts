package com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.api

import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.model.PostResponse
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.model.PostResponseItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderApiService {
        @GET("posts")
        suspend fun getPosts(): Response<PostResponse>

        @GET("posts/{id}")
        suspend fun getIndividualPost(@Path("id") id: Int): Response<PostResponseItem>

}