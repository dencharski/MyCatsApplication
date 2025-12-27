package com.example.mycatsapplication.current_cat.domain.models

data class CurrentCatBreedDataModel(
    val weight: Weight?,
    val id: String?,
    val name: String?,
    val temperament: String?,
    val origin: String?,
    val country_code: String?,
    val life_span: String?,
    val wikipedia_url: String?
) {
    data class Weight(
        val imperial: String?,
        val metric: String?
    )
}