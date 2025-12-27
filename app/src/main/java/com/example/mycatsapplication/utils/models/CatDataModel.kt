package com.example.mycatsapplication.utils.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatDataModel(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int): Parcelable