package com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv


sealed class DataItem {
        // 1) Row with list of RecyclerItem (e.g., horizontal list / section)
        data class RecyclerListItem(val viewType: Int,val items: List<RecyclerItem>) : DataItem()
        // 2) Row with single banner
        data class BannerItem(val viewType: Int,val banner: Banner) : DataItem()
        data class FullScreenBannerItem(val viewType: Int,val fullScreenBanner: FullScreenBanner) : DataItem()
        data class FreshFruitItem(val viewType: Int,val freshFruits:List<FreshFruit> ) : DataItem()

}
data class RecyclerItem(val image: Int, val offer: String)
data class Banner(val image: Int)
data class FullScreenBanner(val image: Int)
data class FreshFruit(val image: Int, val offer: String="Fresh Fruits")
