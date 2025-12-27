package com.example.mycatsapplication.local_cats.domain.api

import com.example.mycatsapplication.utils.models.CatDataModel

interface LocalCatInteractor {
    suspend fun getAllLocalCats():List<CatDataModel>
    suspend fun addCat(cat: CatDataModel): List<CatDataModel>
    suspend fun deleteCat(cat: CatDataModel): List<CatDataModel>
}