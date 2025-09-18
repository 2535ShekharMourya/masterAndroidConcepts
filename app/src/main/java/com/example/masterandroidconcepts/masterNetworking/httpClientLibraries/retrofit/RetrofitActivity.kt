package com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.masterandroidconcepts.R
import com.example.masterandroidconcepts.masterNetworking.httpClientLibraries.retrofit.viewmodel.JsonPlaceHolderViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RetrofitActivity : AppCompatActivity() {
    // ViewModel scoped to this Activity
    lateinit var   viewModel: JsonPlaceHolderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_retrofit)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this)[JsonPlaceHolderViewModel::class.java]

    }
    private fun logMessage(message: String) {
        Log.d("RetrofitActivity", message)
    }
}