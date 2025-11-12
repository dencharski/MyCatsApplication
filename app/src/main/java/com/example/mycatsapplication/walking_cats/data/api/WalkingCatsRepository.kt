package com.example.mycatsapplication.walking_cats.data.api

import com.example.mycatsapplication.walking_cats.domain.models.CatListDataModel

interface WalkingCatsRepository {
    suspend fun getWalkingCats(): CatListDataModel
}