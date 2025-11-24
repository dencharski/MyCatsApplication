package com.example.mycatsapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel

class MainViewModel(): ViewModel() {
    private val _catsIds = MutableLiveData<List<String>>()
    val catsIds: LiveData<List<String>> get() = _catsIds
    private val _localCats = MutableLiveData<List<CatDataModel>>()
    val localCats: LiveData<List<CatDataModel>> get() = _localCats
    private val _mutableSelectedItem = MutableLiveData<String>()
    val selectedItem: LiveData<String> get() = _mutableSelectedItem

    fun selectItem(string: String) {
        _mutableSelectedItem.value = string
    }
}