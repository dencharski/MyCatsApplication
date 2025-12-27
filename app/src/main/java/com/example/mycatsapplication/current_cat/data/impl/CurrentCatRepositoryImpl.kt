package com.example.mycatsapplication.current_cat.data.impl

import android.util.Log
import com.example.mycatsapplication.current_cat.data.api.CurrentCatConverter
import com.example.mycatsapplication.current_cat.data.api.CurrentCatRepository
import com.example.mycatsapplication.current_cat.domain.models.CurrentCatDataModel
import com.example.mycatsapplication.network.CatServices
import com.example.mycatsapplication.utils.models.CatDataModel
import java.io.IOException
import javax.inject.Inject

class CurrentCatRepositoryImpl @Inject constructor(
    private val apiCatServices: CatServices,
    private val currentCatConverter: CurrentCatConverter): CurrentCatRepository {

    private val tag = "cats"
    override suspend fun getCurrentCat(catId: String): CurrentCatDataModel? {
        try {
            val result = apiCatServices.getCurrentCat(catId)
            Log.d(tag, "cats repository = " +
                    "${result?.body()}" +
                    "")
            return currentCatConverter.convertCat(result?.body()!!)

        } catch (e: IOException) {
            Log.d(tag, "cat repository error ${e.message}")
            return null
        }
    }
}