package com.example.mycatsapplication.walking_cats.data.impl

import com.example.mycatsapplication.walking_cats.data.api.CatConverter
import com.example.mycatsapplication.walking_cats.data.models.CatApiDataModel
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel

import javax.inject.Inject

class CatConverterImpl @Inject constructor(): CatConverter {
    override fun convertCats(cats: List<CatApiDataModel>): List<CatDataModel> {
        val convertedCats = mutableListOf<CatDataModel>()
        cats.forEach { item ->
            convertedCats.add(
                CatDataModel(
                    id = item.id,
                    url = item.url,
                    height = item.height,
                    width = item.width
                )
            )
        }
        return convertedCats
    }
}
