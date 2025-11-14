package com.example.mycatsapplication.local_cats.data.impl

import com.example.mycatsapplication.local_cats.data.api.ConverterLocalCat
import com.example.mycatsapplication.local_cats.data.api.LocalCatRepository
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel
import javax.inject.Inject

class LocalCatRepositoryImpl @Inject constructor(private val converterLocalCat: ConverterLocalCat) :
    LocalCatRepository {
    override suspend fun getAllLocalCats(): List<CatDataModel> {
        return listOf<CatDataModel>()
    }

    override suspend fun addCat(cat: CatDataModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCat(cat: CatDataModel) {
        TODO("Not yet implemented")
    }

    override suspend fun getCatsIds(): List<String> {
        return listOf<String>()
    }
}