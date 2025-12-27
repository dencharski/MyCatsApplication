package com.example.mycatsapplication.current_cat.data.api

import com.example.mycatsapplication.current_cat.domain.models.CurrentCatDataModel
import retrofit2.http.Part

interface CurrentCatRepository {
    suspend fun getCurrentCat(catId:String): CurrentCatDataModel?
}