package com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.repository

import com.example.masterandroidconcepts.R
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.Banner
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.DataItem
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.DataItemType
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.FreshFruit
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.FullScreenBanner
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.NetworkException
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.RecyclerItem
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RVRepositoryImp(private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO): RVRepository {
    override suspend fun getHomePageData(): Resource<List<DataItem>> = withContext(ioDispatcher){
        try {
            var mList: ArrayList<DataItem> = ArrayList()
            // best seller list
            val bestSellerList = ArrayList<RecyclerItem>()
            bestSellerList.add(RecyclerItem(R.drawable.bags , "Up to 20% off"))
            bestSellerList.add(RecyclerItem(R.drawable.mobiles, "Up to 10% off"))
            bestSellerList.add(RecyclerItem(R.drawable.watches, "Up to 40% off"))
            bestSellerList.add(RecyclerItem(R.drawable.bags, "Up to 20% off"))
            bestSellerList.add(RecyclerItem(R.drawable.mobiles, "Up to 10% off"))
            bestSellerList.add(RecyclerItem(R.drawable.watches, "Up to 40% off"))

            //clothing
            val clothingList = ArrayList<RecyclerItem>()
            clothingList.add(RecyclerItem(R.drawable.levis_clothing, "Up to 25% off"))
            clothingList.add(RecyclerItem(R.drawable.women_clothing, "Up to 30% off"))
            clothingList.add(RecyclerItem(R.drawable.nikeshoes, "Up to 35% off"))
            clothingList.add(RecyclerItem(R.drawable.levis_clothing, "Up to 25% off"))
            clothingList.add(RecyclerItem(R.drawable.women_clothing, "Up to 30% off"))
            clothingList.add(RecyclerItem(R.drawable.nikeshoes, "Up to 35% off"))

            // fruits list
            val fruitsList = ArrayList<FreshFruit>()
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 25% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 30% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 35% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 25% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 30% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 35% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 25% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 30% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 35% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 25% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 30% off"))
            fruitsList.add(FreshFruit(R.drawable.fresh_fruits_img, "Up to 35% off"))

            mList.add(DataItem.RecyclerListItem(DataItemType.BEST_SELLER, bestSellerList))
            mList.add(DataItem.BannerItem(DataItemType.BANNER, Banner(R.drawable.tv_offer)))
            mList.add(DataItem.FullScreenBannerItem(DataItemType.FULLSCREEN_BANNER, FullScreenBanner(R.drawable.full_screen_banner_img)))
            mList.add(DataItem.RecyclerListItem(DataItemType.CLOTHING, clothingList))
            mList.add(DataItem.BannerItem(DataItemType.BANNER, Banner(R.drawable.nikon_canon_offer)))
            mList.add(DataItem.RecyclerListItem(DataItemType.BEST_SELLER, bestSellerList.asReversed()))
            mList.add(DataItem.BannerItem(DataItemType.BANNER, Banner(R.drawable.offer_shoping)))
            mList.add(DataItem.FullScreenBannerItem(DataItemType.FULLSCREEN_BANNER, FullScreenBanner(R.drawable.full_screen_banner_img)))
            mList.add(DataItem.RecyclerListItem(DataItemType.BEST_SELLER, bestSellerList))
            mList.add(DataItem.BannerItem(DataItemType.BANNER, Banner(R.drawable.tv_offer)))
            mList.add(DataItem.RecyclerListItem(DataItemType.CLOTHING, clothingList))
            mList.add(DataItem.FullScreenBannerItem(DataItemType.FULLSCREEN_BANNER, FullScreenBanner(R.drawable.full_screen_banner_img)))
            mList.add(DataItem.BannerItem(DataItemType.BANNER, Banner(R.drawable.nikon_canon_offer)))
            mList.add(DataItem.RecyclerListItem(DataItemType.BEST_SELLER, bestSellerList.asReversed()))
            mList.add(DataItem.RecyclerListItem(DataItemType.BEST_SELLER, bestSellerList.asReversed()))
            mList.add(DataItem.FreshFruitItem(DataItemType.FRUITS, fruitsList))
            Resource.Success(mList)
        }catch ( e: Exception){
            e.printStackTrace()
            Resource.Failure(e as NetworkException)
        }

        }



}