package com.example.mycatsapplication.current_cat.data.dto_models

data class CurrentCatDTO(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
    val breedsList: List<CurrentCatBreedDTO>?,
    val categoriesList: List<CurrentCatCategoriesDTO>?
)
