package com.example.mycatsapplication.walking_cats.domain.api

import com.example.mycatsapplication.walking_cats.domain.models.CatListDataModel

interface WalkingCatsInteractor {
    suspend fun getWalkingCats(): CatListDataModel
}