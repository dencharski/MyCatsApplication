package com.example.mycatsapplication.network

import com.example.mycatsapplication.walking_cats.data.models.CatApiDataModel
import retrofit2.Response
import retrofit2.http.GET

interface CatServices {

    @GET("search?limit=12")
    suspend fun getWalkingCats(): Response<List<CatApiDataModel>>
}