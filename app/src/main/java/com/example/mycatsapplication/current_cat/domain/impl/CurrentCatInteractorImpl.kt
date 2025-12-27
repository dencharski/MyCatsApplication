package com.example.mycatsapplication.current_cat.domain.impl

import com.example.mycatsapplication.current_cat.data.api.CurrentCatRepository
import com.example.mycatsapplication.current_cat.domain.api.CurrentCatInteractor
import com.example.mycatsapplication.current_cat.domain.models.CurrentCatDataModel
import com.example.mycatsapplication.local_cats.data.api.LocalCatRepository
import com.example.mycatsapplication.utils.models.CatDataModel
import javax.inject.Inject

class CurrentCatInteractorImpl @Inject constructor(
    private val currentCatRepository: CurrentCatRepository,
    private val localCatRepository: LocalCatRepository) :
    CurrentCatInteractor {
    override suspend fun getCurrentCat(catId: String): CurrentCatDataModel? {
        return currentCatRepository.getCurrentCat(catId)
    }

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