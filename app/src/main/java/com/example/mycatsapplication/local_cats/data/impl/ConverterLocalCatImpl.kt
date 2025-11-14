package com.example.mycatsapplication.local_cats.data.impl

import com.example.mycatsapplication.local_cats.data.api.ConverterLocalCat
import com.example.mycatsapplication.local_cats.data.models.LocalCatDataModel
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel
import javax.inject.Inject

class ConverterLocalCatImpl @Inject constructor() : ConverterLocalCat {

    override fun convertToLocal(cat: CatDataModel): LocalCatDataModel {
        return LocalCatDataModel(
            id = cat.id,
            url = cat.url,
            width = cat.width,
            height = cat.height
        )
    }

    override fun convertFromLocal(cat: LocalCatDataModel): CatDataModel {
        return CatDataModel(
            id = cat.id,
            url = cat.url,
            width = cat.width,
            height = cat.height
        )
    }
}