package com.example.mycatsapplication.current_cat.domain.api

import com.example.mycatsapplication.current_cat.domain.models.CurrentCatDataModel
import com.example.mycatsapplication.utils.models.CatDataModel

interface CurrentCatInteractor {
    suspend fun getCurrentCat(catId:String): CurrentCatDataModel?
    suspend fun getAllLocalCats():List<CatDataModel>
    suspend fun addCat(cat: CatDataModel): List<CatDataModel>
    suspend fun deleteCat(cat: CatDataModel): List<CatDataModel>
}