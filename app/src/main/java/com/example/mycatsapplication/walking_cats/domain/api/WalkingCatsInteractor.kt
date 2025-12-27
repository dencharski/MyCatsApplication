package com.example.mycatsapplication.walking_cats.domain.api

import com.example.mycatsapplication.utils.models.CatDataModel


interface WalkingCatsInteractor {
    suspend fun getWalkingCats(): List<CatDataModel>

    suspend fun getAllLocalCats():List<CatDataModel>
    suspend fun addCat(catDataModel: CatDataModel): List<CatDataModel>
    suspend fun deleteCat(catDataModel: CatDataModel): List<CatDataModel>
}