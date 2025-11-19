package com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv

data class HomeDataItem(val viewType: Int) {

    var recyclerItemList: List<RecyclerItem>? = null
    var banner: Banner? = null

    constructor(viewType: Int, recyclerItemList: List<RecyclerItem>) : this(viewType) {
        this.recyclerItemList = recyclerItemList
    }

    constructor(viewType: Int, banner: Banner) : this(viewType) {
        this.banner = banner
    }

}
