package com.example.mycatsapplication.walking_cats.data.impl

import android.util.Log
import com.example.mycatsapplication.network.CatServices
import com.example.mycatsapplication.walking_cats.data.api.CatConverter
import com.example.mycatsapplication.walking_cats.data.api.WalkingCatsRepository
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel
import com.example.mycatsapplication.walking_cats.domain.models.CatListDataModel
import java.io.IOException
import javax.inject.Inject

class WalkingCatsRepositoryImpl @Inject constructor(
    private val catConverterImpl: CatConverter,
    private val apiCatServices: CatServices
) : WalkingCatsRepository {
    private val tag = "cats"
    override suspend fun getWalkingCats(): CatListDataModel {
        try {
            val result = apiCatServices.getWalkingCats()
            Log.d(tag, "cats repository = " +
                    "${result.message()}" +
                    "")
            return catConverterImpl.convertCats(result.body()!!)

        } catch (e: IOException) {
            Log.d(tag, "cat repository error ${e.message}")
            return CatListDataModel(listOf<CatDataModel>())
        }

    }
}