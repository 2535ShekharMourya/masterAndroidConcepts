package com.example.masterandroidconcepts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        🔹 1. JSONPlaceholder
//
//        👉 https://jsonplaceholder.typicode.com
//
//        100% free, no API key
//
//        Supports GET, POST, PUT, PATCH, DELETE
//
//        Example endpoints:
//
//        GET https://jsonplaceholder.typicode.com/posts
//
//        POST https://jsonplaceholder.typicode.com/posts
//
//        PUT https://jsonplaceholder.typicode.com/posts/1
//
//        PATCH https://jsonplaceholder.typicode.com/posts/1
//
//        DELETE https://jsonplaceholder.typicode.com/posts/1
//
//        ⚠️ Note: It won’t actually change the database (fake responses), but great for Android practice with Retrofit/Volley.
//
//        🔹 2. Reqres
//
//        👉 https://reqres.in
//
//        Designed for frontend developers to practice
//
//                Supports GET, POST, PUT, PATCH, DELETE
//
//        Example endpoints:
//
//        GET https://reqres.in/api/users
//
//        POST https://reqres.in/api/users
//
//        PUT https://reqres.in/api/users/2
//
//        PATCH https://reqres.in/api/users/2
//
//        DELETE https://reqres.in/api/users/2
//
//        🔹 3. DummyJSON
//
//        👉 https://dummyjson.com
//
//        Free fake REST API with real CRUD
//
//        Supports GET, POST, PUT, PATCH, DELETE
//
//        Example endpoints:
//
//        GET https://dummyjson.com/products
//
//        POST https://dummyjson.com/products/add
//
//        PUT https://dummyjson.com/products/1
//
//        PATCH https://dummyjson.com/products/1
//
//        DELETE https://dummyjson.com/products/1
//
//        🔹 4. GoRest API
//
//        👉 https://gorest.co.in/
//
//        Free public REST API with CRUD support
//
//        Needs a free API key for POST/PUT/DELETE
//
//        Example endpoints:
//
//        GET https://gorest.co.in/public/v2/users
//
//        POST https://gorest.co.in/public/v2/users
//
//        PUT https://gorest.co.in/public/v2/users/{id}
//
//        DELETE https://gorest.co.in/public/v2/users/{id}
    }
}