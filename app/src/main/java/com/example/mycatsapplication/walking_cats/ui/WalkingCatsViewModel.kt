package com.example.mycatsapplication.walking_cats.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycatsapplication.walking_cats.domain.api.WalkingCatsInteractor
import com.example.mycatsapplication.walking_cats.domain.models.CatDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class WalkingCatsViewModel @Inject constructor(
    private val walkingCatsInteractor: WalkingCatsInteractor
) : ViewModel() {
    private val tag = "cats"
    private val _mutableWalkingCatList = MutableLiveData<List<CatDataModel>>()
    val walkingCatList: LiveData<List<CatDataModel>> get() = _mutableWalkingCatList
    private val _mutableCatIdList = MutableLiveData<List<String>>()
    val catIdList: LiveData<List<String>> get() = _mutableCatIdList

    init {
        getWalkingCats()
    }

    fun getWalkingCats() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = walkingCatsInteractor.getWalkingCats()
            withContext(Dispatchers.Main) {
                setCatList(result)
            }
        }
    }

    fun setCatList(cats: List<CatDataModel>) {
        _mutableWalkingCatList.postValue(cats)
    }

    fun getAllLocalCats() {
        viewModelScope.launch(Dispatchers.Main) {
            val result = walkingCatsInteractor.getAllLocalCats()
            withContext(Dispatchers.Main) {
                val ids = mutableListOf<String>()
                result.forEach { ids.add(it.id) }
                _mutableCatIdList.postValue(ids)
            }
        }
    }

    fun addCat(catDataModel: CatDataModel) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = walkingCatsInteractor.addCat(catDataModel)

            val ids = mutableListOf<String>()
            result.forEach {
                ids.add(it.id)
                Log.d(tag, "cat = ${it.id}")
            }
            _mutableCatIdList.postValue(ids)

        }
    }

    fun deleteCat(catDataModel: CatDataModel) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = walkingCatsInteractor.deleteCat(catDataModel)
            withContext(Dispatchers.Main) {
                val ids = mutableListOf<String>()
                result.forEach {
                    ids.add(it.id)
                    Log.d(tag, "cat = ${it.id}")
                }

                _mutableCatIdList.postValue(ids)
            }
        }
    }

}