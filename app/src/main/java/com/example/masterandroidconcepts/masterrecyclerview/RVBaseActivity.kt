package com.example.masterandroidconcepts.masterrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.masterandroidconcepts.R
import com.example.masterandroidconcepts.databinding.ActivityRvbaseBinding

class RVBaseActivity : AppCompatActivity() {
    lateinit var binding: ActivityRvbaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRvbaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val itemList = listOf<ListItem>(
            ListItem.TextItem("Hello, World!"),
            ListItem.ImageItem(R.drawable.shekhar),
            ListItem.ImageItem(R.drawable.voter_id2),
            ListItem.VerticalImageItem(R.drawable.shekhar,"Shekhar"),
            ListItem.HorizontalImageItem(R.drawable.voter_id2,"Voter ID"),
            ListItem.ContactItem("Shekhar","9876543210",R.drawable.shekhar),
            ListItem.EmailItem("Shekhar","Application","12pm"),
            ListItem.MusicItem(R.drawable.voter_id2,"Tum hi ho","Arijit Singh")

        )

        val adapter = MultiTypeAdapter(itemList)
        binding.mRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.mRecyclerview.adapter = adapter

    }
    fun setViewContent(){
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}