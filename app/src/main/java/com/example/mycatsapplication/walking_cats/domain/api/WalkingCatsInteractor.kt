package com.example.mycatsapplication.walking_cats.domain.api

import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel


interface WalkingCatsInteractor {
    suspend fun getWalkingCats(): List<CatDataModel>
}