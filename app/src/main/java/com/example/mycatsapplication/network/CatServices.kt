package com.example.mycatsapplication.network

import com.example.mycatsapplication.current_cat.data.dto_models.CurrentCatDTO
import com.example.mycatsapplication.current_cat.domain.models.CurrentCatDataModel
import com.example.mycatsapplication.walking_cats.data.models.CatApiDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface CatServices {

    @GET("search?limit=12")
    suspend fun getWalkingCats(): Response<List<CatApiDataModel>>?


    @GET("{catId}")
    suspend fun getCurrentCat( @Path("catId") catId: String): Response<CurrentCatDTO>?
    // https://api.thecatapi.com/v1/images/0XYvRd7oD
    // @Query("term") text: String
}