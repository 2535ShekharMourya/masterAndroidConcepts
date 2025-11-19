package com.example.masterandroidconcepts.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.masterandroidconcepts.R
import com.example.masterandroidconcepts.databinding.ActivityRvactivityBinding
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.Banner
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.DataItem
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.DataItemType
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.FreshFruit
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.FullScreenBanner
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.HomepageAdapter
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.repository.RVRepository
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.repository.RVRepositoryImp
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.viewmodels.RVViewModel
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.viewmodels.RVViewmodelFactory
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.RecyclerItem
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.Resource

class RVActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRvactivityBinding
    private val rvRepo: RVRepository = RVRepositoryImp()
    // 2. Instantiate the Factory, providing the repo instance
    private val viewModelFactory = RVViewmodelFactory(rvRepo)
    // 3. Use the by viewModels delegate with the Factory
    private val viewModel: RVViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRvactivityBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        viewCompat()
        setUpRecyclerView()


        viewModel.getHomePageData()
        viewModel.homepageData.observe(this) {
            when (it) {
                is Resource.Success -> {
                    // Update the UI with the data
                    val data = it.result
                    val adapter = HomepageAdapter(data)
                    binding.mainRecyclerView.adapter = adapter
                }
                is Resource.Loading -> {}
                is Resource.Failure -> {}
            }


        }
    }
    private fun setUpRecyclerView() {
       // binding.mainRecyclerView.setHasFixedSize (true)
     //   binding.mainRecyclerView.layoutManager = LinearLayoutManager (this)
    }
    private fun viewCompat(){
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }
}