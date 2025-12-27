package com.example.mycatsapplication.current_cat.data.dto_models

data class CurrentCatBreedDTO(
    val weight: WeightDTO?,
    val id: String?,
    val name: String?,
    val temperament: String?,
    val origin: String?,
    val country_code: String?,
    val life_span: String?,
    val wikipedia_url: String?
) {
    data class WeightDTO(
        val imperial: String?,
        val metric: String?
    )
}