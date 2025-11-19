package com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.model

import android.net.http.NetworkException

sealed class Resource<out R> {
    data class Success<out R>(val result: R): Resource<R>()
    data class Failure(val exception: NetworkException): Resource<Nothing>()
    data object Loading: Resource<Nothing>()
}