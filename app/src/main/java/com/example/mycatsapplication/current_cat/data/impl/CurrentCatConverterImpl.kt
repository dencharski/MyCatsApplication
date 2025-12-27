package com.example.mycatsapplication.current_cat.data.impl

import com.example.mycatsapplication.current_cat.data.api.CurrentCatConverter
import com.example.mycatsapplication.current_cat.data.dto_models.CurrentCatBreedDTO
import com.example.mycatsapplication.current_cat.data.dto_models.CurrentCatCategoriesDTO
import com.example.mycatsapplication.current_cat.data.dto_models.CurrentCatDTO
import com.example.mycatsapplication.current_cat.domain.models.CurrentCatBreedDataModel
import com.example.mycatsapplication.current_cat.domain.models.CurrentCatCategoriesDataModel
import com.example.mycatsapplication.current_cat.domain.models.CurrentCatDataModel
import javax.inject.Inject

class CurrentCatConverterImpl @Inject constructor() : CurrentCatConverter {
    override fun convertCat(cat: CurrentCatDTO): CurrentCatDataModel {
        return CurrentCatDataModel(
            id = cat.id,
            url = cat.url,
            width = cat.width,
            height = cat.height,
            breedsList = getBreedsList(cat.breedsList),
            categoriesList = getCategoriesList(cat.categoriesList)
        )
    }

    private fun getBreedsList(list: List<CurrentCatBreedDTO>?): List<CurrentCatBreedDataModel>? {
        if (list.isNullOrEmpty()) {
            return null
        } else {
            val listBreed = mutableListOf<CurrentCatBreedDataModel>()
            list.forEach { item ->
                listBreed.add(
                    CurrentCatBreedDataModel(
                        weight = getWeight(item.weight),
                        id = item.id,
                        name = item.name,
                        temperament = item.temperament,
                        origin = item.origin,
                        country_code = item.country_code,
                        life_span = item.life_span,
                        wikipedia_url = item.wikipedia_url
                    )
                )
            }
            return listBreed
        }
    }

    private fun getWeight(weight: CurrentCatBreedDTO.WeightDTO?): CurrentCatBreedDataModel.Weight? {
        if (weight == null) {
            return null
        } else {
            return CurrentCatBreedDataModel.Weight(
                imperial = weight.imperial,
                metric = weight.metric
            )
        }

    }

    private fun getCategoriesList(list: List<CurrentCatCategoriesDTO>?): List<CurrentCatCategoriesDataModel>? {

        if (list.isNullOrEmpty()) {
            return null
        } else {
            val listCategories = mutableListOf<CurrentCatCategoriesDataModel>()
            list.forEach { item ->
                listCategories.add(
                    CurrentCatCategoriesDataModel(
                        id = item.id,
                        name = item.name
                    )
                )
            }
            return listCategories
        }
    }
}