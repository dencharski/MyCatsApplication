package com.example.mycatsapplication.current_cat.data.api

import com.example.mycatsapplication.current_cat.data.dto_models.CurrentCatDTO
import com.example.mycatsapplication.current_cat.domain.models.CurrentCatDataModel

interface CurrentCatConverter {
    fun convertCat(cat: CurrentCatDTO): CurrentCatDataModel
}