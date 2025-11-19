package com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.repository

import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.DataItem
import com.example.masterandroidconcepts.recyclerview.multiviewtypenestedrv.Resource

interface RVRepository {
    suspend fun getHomePageData(): Resource<List<DataItem>>
}