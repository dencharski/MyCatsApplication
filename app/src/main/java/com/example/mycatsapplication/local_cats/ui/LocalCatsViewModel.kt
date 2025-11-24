package com.example.mycatsapplication.local_cats.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycatsapplication.local_cats.domain.api.LocalCatInteractor
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class LocalCatsViewModel @Inject constructor(private val localCatInteractor: LocalCatInteractor) :
    ViewModel() {
    private val _catsIds = MutableLiveData<List<String>>()
    val catsIds: LiveData<List<String>> get() = _catsIds
    private val _localCats = MutableLiveData<List<CatDataModel>>()
    val localCats: LiveData<List<CatDataModel>> get() = _localCats

    fun getAllLocalCats() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = localCatInteractor.getAllLocalCats()
            withContext(Dispatchers.Main) {
                val ids = mutableListOf<String>()
                result.forEach { ids.add(it.id) }
                _catsIds.postValue(ids)
                _localCats.postValue(result)

            }
        }
    }

    fun addCat(cat: CatDataModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = localCatInteractor.addCat(cat)
            withContext(Dispatchers.Main) {
                val ids = mutableListOf<String>()
                result.forEach { ids.add(it.id) }
                _catsIds.postValue(ids)
                _localCats.postValue(result)
            }
        }
    }

    fun deleteCat(cat: CatDataModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = localCatInteractor.deleteCat(cat)
            withContext(Dispatchers.Main) {
                val ids = mutableListOf<String>()
                result.forEach { ids.add(it.id) }
                _catsIds.postValue(ids)
                _localCats.postValue(result)
            }
        }
    }

}