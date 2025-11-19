package com.example.mycatsapplication.local_cats.data.impl

import android.content.SharedPreferences
import com.example.mycatsapplication.local_cats.data.api.ConverterLocalCat
import com.example.mycatsapplication.local_cats.data.api.LocalCatRepository
import com.example.mycatsapplication.local_cats.data.models.LocalCatDataModel
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel
import com.google.gson.Gson
import javax.inject.Inject

class LocalCatRepositoryImpl @Inject constructor(
    private val converterLocalCat: ConverterLocalCat,
    private val sharedPreferences: SharedPreferences
) : LocalCatRepository {

    private var catList = arrayListOf<LocalCatDataModel>()
    private var catListId = arrayListOf<String>()
    private val capacity: Int = 20
    private val tag = "cats"


    override suspend fun getAllLocalCats(): List<CatDataModel> {
        addCatListAndCatListId()
        return catList.map { converterLocalCat.convertFromLocal(it) }
    }

    override suspend fun addCat(catDataModel: CatDataModel): List<CatDataModel> {
        val arrayListOfLocalCatDataModel = arrayListOf<LocalCatDataModel>()
        val localCat = converterLocalCat.convertToLocal(catDataModel)
        if (!catListId.contains(localCat.id)) {
            arrayListOfLocalCatDataModel.add(localCat)
            arrayListOfLocalCatDataModel.addAll(catList)
            val arCatList = arrayListOfLocalCatDataModel.take(capacity)
            arrayListOfLocalCatDataModel.clear()
            arrayListOfLocalCatDataModel.addAll(arCatList)
            writeArray(arrayListOfLocalCatDataModel)
        }
       return getAllLocalCats()

    }

    override suspend fun deleteCat(catDataModel: CatDataModel): List<CatDataModel> {
        val arrayListOfLocalCatDataModel = arrayListOf<LocalCatDataModel>()
        val localCat = converterLocalCat.convertToLocal(catDataModel)
        if (catListId.contains(localCat.id)) {
            catList.removeIf { it.id == localCat.id }
            arrayListOfLocalCatDataModel.addAll(catList)
            writeArray(arrayListOfLocalCatDataModel)
        }
        return getAllLocalCats()
    }

    override suspend fun getCatsIds(): List<String> {
        addCatListAndCatListId()
        return catListId
    }

    private fun addCatListAndCatListId() {
        catList.clear()
        catList.addAll(read())
        catListId.clear()
        catList.forEach { catListId.add(it.id) }
    }

    private fun read(): Array<LocalCatDataModel> {
        val json = sharedPreferences.getString("CAT_LIST_KEY", null) ?: return emptyArray()
        return Gson().fromJson(json, Array<LocalCatDataModel>::class.java)
    }

    private fun writeArray(cats: List<LocalCatDataModel>) {
        removeTrackListInSharedPreferences()
        val json = Gson().toJson(cats)
        sharedPreferences.edit()
            .putString("CAT_LIST_KEY", json)
            .apply()

    }

    private fun removeTrackListInSharedPreferences() {
        sharedPreferences.edit()
            .remove("CAT_LIST_KEY")
            .apply()
        catList.clear()
        catListId.clear()
    }

}