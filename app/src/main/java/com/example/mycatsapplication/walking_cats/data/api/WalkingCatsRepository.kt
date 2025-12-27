package com.example.mycatsapplication.walking_cats.data.api

import com.example.mycatsapplication.utils.models.CatDataModel


interface WalkingCatsRepository {
    suspend fun getWalkingCats(): List<CatDataModel>
}