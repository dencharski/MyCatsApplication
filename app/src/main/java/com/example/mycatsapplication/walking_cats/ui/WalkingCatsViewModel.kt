package com.example.mycatsapplication.walking_cats.ui

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
    private val _catList = MutableLiveData<List<CatDataModel>>()
    val catList: LiveData<List<CatDataModel>> get() = _catList

    fun getWalkingCats() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = walkingCatsInteractor.getWalkingCats()
            withContext(Dispatchers.Main) {
                setCatList(result)
            }
        }
    }

    fun setCatList(cats: List<CatDataModel>) {
        _catList.postValue(cats)
    }

}