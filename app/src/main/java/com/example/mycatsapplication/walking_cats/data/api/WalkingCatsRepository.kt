package com.example.mycatsapplication.walking_cats.data.api

import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel


interface WalkingCatsRepository {
    suspend fun getWalkingCats(): List<CatDataModel>
}