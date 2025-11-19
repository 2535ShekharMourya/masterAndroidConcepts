package com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.masterandroidconcepts.databinding.BestSellerLayoutBinding
import com.example.masterandroidconcepts.databinding.ClothingLayoutBinding
import com.example.masterandroidconcepts.databinding.FruitItemBinding

class FreshFruitAdapter(private val viewType: Int, private val recyclerItemList: List<FreshFruit>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class FruitViewHolder(private val binding: FruitItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindFruitsView(recyclerItem: FreshFruit) {
            binding.fruitImage.setImageResource(recyclerItem.image)
            binding.fruitText.text = recyclerItem.offer
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = FruitItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FruitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recyclerItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FruitViewHolder).bindFruitsView(recyclerItemList[position])

    }
}