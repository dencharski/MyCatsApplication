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
    private val _listOfLocalCatsIds = MutableLiveData<List<String>>()
    val listOfLocalCatsIds: LiveData<List<String>> get() = _listOfLocalCatsIds
    private val _listOfLocalCats = MutableLiveData<List<CatDataModel>>()
    val listOfLocalCats: LiveData<List<CatDataModel>> get() = _listOfLocalCats

    fun getAllLocalCats() {
        viewModelScope.launch(Dispatchers.Main) {
            val result = localCatInteractor.getAllLocalCats()

                val ids = mutableListOf<String>()
                result.forEach { ids.add(it.id) }
                _listOfLocalCatsIds.postValue(ids)
                _listOfLocalCats.postValue(result)


        }
    }

    fun addCat(cat: CatDataModel) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = localCatInteractor.addCat(cat)

                val ids = mutableListOf<String>()
                result.forEach { ids.add(it.id) }
                _listOfLocalCatsIds.postValue(ids)
                _listOfLocalCats.postValue(result)

        }
    }

    fun deleteCat(cat: CatDataModel) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = localCatInteractor.deleteCat(cat)

                val ids = mutableListOf<String>()
                result.forEach { ids.add(it.id) }
                _listOfLocalCatsIds.postValue(ids)
                _listOfLocalCats.postValue(result)

        }
    }

}