package com.example.mycatsapplication.walking_cats.data.impl

import com.example.mycatsapplication.walking_cats.data.api.CatConverter
import com.example.mycatsapplication.walking_cats.data.models.CatApiDataModel
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel
import com.example.mycatsapplication.walking_cats.domain.models.CatListDataModel
import javax.inject.Inject

class CatConverterImpl @Inject constructor(): CatConverter {
    override fun convertCats(cats: List<CatApiDataModel>): CatListDataModel {
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
        return CatListDataModel(convertedCats)
    }
}
