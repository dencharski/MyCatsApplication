package com.example.mycatsapplication.current_cat.domain.models

data class CurrentCatDataModel(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
    val breedsList: List<CurrentCatBreedDataModel>?,
    val categoriesList: List<CurrentCatCategoriesDataModel>?
)
