package com.example.mycatsapplication.local_cats.data.api

import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel

interface LocalCatRepository {
    suspend fun getAllLocalCats():List<CatDataModel>
    suspend fun addCat(catDataModel: CatDataModel): List<CatDataModel>
    suspend fun deleteCat(catDataModel: CatDataModel): List<CatDataModel>
}