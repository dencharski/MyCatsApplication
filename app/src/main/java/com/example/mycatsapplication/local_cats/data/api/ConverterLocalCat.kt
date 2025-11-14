package com.example.mycatsapplication.local_cats.data.api

import com.example.mycatsapplication.local_cats.data.models.LocalCatDataModel
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel

interface ConverterLocalCat {
    fun convertToLocal(cat: CatDataModel): LocalCatDataModel
    fun convertFromLocal(cat: LocalCatDataModel): CatDataModel
}