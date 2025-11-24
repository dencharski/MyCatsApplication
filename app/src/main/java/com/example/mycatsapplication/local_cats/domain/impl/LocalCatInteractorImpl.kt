package com.example.mycatsapplication.local_cats.domain.impl

import com.example.mycatsapplication.local_cats.data.api.LocalCatRepository
import com.example.mycatsapplication.local_cats.domain.api.LocalCatInteractor
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel
import javax.inject.Inject

class LocalCatInteractorImpl @Inject constructor(private val localCatRepository: LocalCatRepository): LocalCatInteractor {
    override suspend fun getAllLocalCats(): List<CatDataModel> {
        return localCatRepository.getAllLocalCats()
    }

    override suspend fun addCat(cat: CatDataModel): List<CatDataModel> {
        return localCatRepository.addCat(cat)
    }

    override suspend fun deleteCat(cat: CatDataModel): List<CatDataModel> {
       return localCatRepository.deleteCat(cat)
    }

}