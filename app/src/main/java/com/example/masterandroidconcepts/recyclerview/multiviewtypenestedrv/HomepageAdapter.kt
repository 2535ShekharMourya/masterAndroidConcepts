package com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.masterandroidconcepts.databinding.BannerItemBinding
import com.example.masterandroidconcepts.databinding.EachItemBinding
import com.example.masterandroidconcepts.databinding.FreshfruitItemBinding
import com.example.masterandroidconcepts.databinding.FullscreenbannerItemBinding

class HomepageAdapter(private val dataList: List<DataItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is DataItem.BannerItem -> DataItemType.BANNER
            is DataItem.RecyclerListItem -> DataItemType.RECYCLER_VIEW_TYPE
            is DataItem.FullScreenBannerItem -> DataItemType.FULLSCREEN_BANNER
            is DataItem.FreshFruitItem -> DataItemType.FRUITS
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DataItemType.BANNER -> {
                val binding =
                    BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BannerItemViewHolder(binding)
            }
            DataItemType.FULLSCREEN_BANNER -> {
                val binding =
                    FullscreenbannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                FullScreenBannerItemViewHolder(binding)
            }
            DataItemType.FRUITS -> {
                val binding =
                    FreshfruitItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                FreshFruitItemViewHolder(binding)
            }
            else -> {
                val binding =
                    EachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RecyclerItemViewHolder(binding)
            }
        }

    }

    override fun getItemCount(): Int =dataList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = dataList[position]) {
            is DataItem.BannerItem -> {
                (holder as BannerItemViewHolder).bindBannerView(item.banner)
            }
            is DataItem.RecyclerListItem -> {
                when (item.viewType) {
                    DataItemType.BEST_SELLER -> {
                        (holder as RecyclerItemViewHolder).bindBestSellerRecyclerView(item.items)
                    }
                    DataItemType.CLOTHING -> {
                        (holder as RecyclerItemViewHolder).bindClothingRecyclerView(item.items)
                    }
                }
            }
            is DataItem.FullScreenBannerItem -> {
                (holder as FullScreenBannerItemViewHolder).bindFullScreenBannerView(item.fullScreenBanner)
            }

            is DataItem.FreshFruitItem -> {
                (holder as FreshFruitItemViewHolder).bindFreshFruitView(item.freshFruits)
            }
        }
    }

    inner class BannerItemViewHolder(private val binding: BannerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindBannerView(banner: Banner) {
            binding.bannerIv.setImageResource(banner.image)
        }

    }

    inner class FullScreenBannerItemViewHolder(private val binding: FullscreenbannerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindFullScreenBannerView(fullScreenBanner: FullScreenBanner) {
            binding.fullscreenBannerIv.setImageResource(fullScreenBanner.image)
        }

    }
    inner class FreshFruitItemViewHolder(private val binding: FreshfruitItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.freshFruitRecyclerView.layoutManager = GridLayoutManager(binding.root.context,2)
        }
            fun bindFreshFruitView(freshFruits:List< FreshFruit>) {
                val adapter = FreshFruitAdapter(DataItemType.FRUITS, freshFruits)
                binding.freshFruitRecyclerView.adapter = adapter
            }

    }

    inner class RecyclerItemViewHolder(private val binding: EachItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.childRecyclerView.setHasFixedSize(true)
            binding.childRecyclerView.layoutManager =
                LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
        }

        fun bindClothingRecyclerView(recyclerItemList: List<RecyclerItem>) {
            val adapter = ChildAdapter(DataItemType.CLOTHING, recyclerItemList)
            binding.childRecyclerView.adapter = adapter
        }

        fun bindBestSellerRecyclerView(recyclerItemList: List<RecyclerItem>) {

//            val snapHelper = PagerSnapHelper()
//            snapHelper.attachToRecyclerView(binding.childRecyclerView)
            val adapter = ChildAdapter(DataItemType.BEST_SELLER, recyclerItemList)
            binding.childRecyclerView.adapter = adapter
        }
    }

}