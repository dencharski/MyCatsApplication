package com.example.mycatsapplication.walking_cats.domain.impl

import com.example.mycatsapplication.local_cats.data.api.LocalCatRepository
import com.example.mycatsapplication.walking_cats.data.api.WalkingCatsRepository
import com.example.mycatsapplication.walking_cats.domain.api.WalkingCatsInteractor
import com.example.mycatsapplication.utils.models.CatDataModel
import javax.inject.Inject

class WalkingCatsInteractorImpl @Inject constructor(
    private val walkingCatsRepository: WalkingCatsRepository,
    private val localCatRepository: LocalCatRepository
) : WalkingCatsInteractor {
    override suspend fun getWalkingCats(): List<CatDataModel> {
        return walkingCatsRepository.getWalkingCats()
    }

    override suspend fun getAllLocalCats(): List<CatDataModel> {
        return localCatRepository.getAllLocalCats()
    }

    override suspend fun addCat(catDataModel: CatDataModel): List<CatDataModel> {
        return localCatRepository.addCat(catDataModel)
    }

    override suspend fun deleteCat(catDataModel: CatDataModel): List<CatDataModel> {
        return localCatRepository.deleteCat(catDataModel)
    }
}