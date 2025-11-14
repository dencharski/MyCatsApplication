package com.example.mycatsapplication.local_cats.domain.api

import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel

interface LocalCatInteractor {
    suspend fun getAllLocalCats():List<CatDataModel>
    suspend fun addCat(cat: CatDataModel)
    suspend fun deleteCat(cat: CatDataModel)
    suspend fun getCatsIds(): List<String>
}