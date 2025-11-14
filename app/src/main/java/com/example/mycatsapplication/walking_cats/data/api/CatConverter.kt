package com.example.mycatsapplication.walking_cats.data.api

import com.example.mycatsapplication.walking_cats.data.models.CatApiDataModel
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel


interface CatConverter {
    fun convertCats(cats: List<CatApiDataModel>): List<CatDataModel>
}