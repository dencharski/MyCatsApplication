package com.example.mycatsapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel

class MainViewModel() : ViewModel() {
    private val _mutableCatsIds = MutableLiveData<List<String>>()
    val catsIds: LiveData<List<String>> get() = _mutableCatsIds
    private val _mutableLocalCats = MutableLiveData<List<CatDataModel>>()
    val localCats: LiveData<List<CatDataModel>> get() = _mutableLocalCats
    private val _mutableSelectedItem = MutableLiveData<String>()
    val selectedItem: LiveData<String> get() = _mutableSelectedItem

    fun selectItem(string: String) {
        _mutableSelectedItem.value = string
    }

    fun setCatIds(listIds: List<String>) {
        _mutableCatsIds.postValue(listIds)
    }

    fun setLocalCats(localCats: List<CatDataModel>) {
        _mutableLocalCats.postValue(localCats)
    }
}