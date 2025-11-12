package com.example.mycatsapplication.walking_cats.data.api

import com.example.mycatsapplication.walking_cats.data.models.CatApiDataModel
import com.example.mycatsapplication.walking_cats.domain.models.CatListDataModel

interface CatConverter {
    fun convertCats(cats: List<CatApiDataModel>): CatListDataModel
}