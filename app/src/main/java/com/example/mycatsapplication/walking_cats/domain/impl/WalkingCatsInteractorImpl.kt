package com.example.mycatsapplication.walking_cats.domain.impl

import com.example.mycatsapplication.walking_cats.data.api.WalkingCatsRepository
import com.example.mycatsapplication.walking_cats.domain.api.WalkingCatsInteractor
import com.example.mycatsapplication.walking_cats.domain.models.CatListDataModel
import javax.inject.Inject

class WalkingCatsInteractorImpl @Inject constructor(
    private val walkingCatsRepository: WalkingCatsRepository
) : WalkingCatsInteractor {
    override suspend fun getWalkingCats(): CatListDataModel {
        return walkingCatsRepository.getWalkingCats()
    }
}