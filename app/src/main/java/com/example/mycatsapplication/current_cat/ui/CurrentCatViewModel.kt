package com.example.mycatsapplication.current_cat.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycatsapplication.current_cat.domain.api.CurrentCatInteractor
import com.example.mycatsapplication.current_cat.domain.models.CurrentCatDataModel
import com.example.mycatsapplication.utils.models.CatDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CurrentCatViewModel @Inject constructor(private val currentCatInteractor: CurrentCatInteractor) :
    ViewModel() {
    private var catAppKey = ""
    private val tag = "cats"
    private val _currentCatDataModel = MutableLiveData<CurrentCatDataModel>()
    val currentCatDataModel: LiveData<CurrentCatDataModel> get() = _currentCatDataModel
    private val _catIdList = MutableLiveData<List<String>>()
    val catIdList: LiveData<List<String>> get() = _catIdList

    fun getCurrentCat(catId: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val result = currentCatInteractor.getCurrentCat(catId)
            withContext(Dispatchers.Main) {
                if (result != null) {
                    _currentCatDataModel.postValue(result)
                }

            }
        }
    }

    fun getAllLocalCats() {
        viewModelScope.launch(Dispatchers.Main) {
            val result = currentCatInteractor.getAllLocalCats()
            withContext(Dispatchers.Main) {
                val ids = mutableListOf<String>()
                result.forEach { ids.add(it.id) }
                _catIdList.postValue(ids)
            }
        }
    }

    fun addCat(catDataModel: CatDataModel) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = currentCatInteractor.addCat(catDataModel)

            val ids = mutableListOf<String>()
            result.forEach {
                ids.add(it.id)
                Log.d(tag, "cat = ${it.id}")
            }
            _catIdList.postValue(ids)

        }
    }

    fun deleteCat(catDataModel: CatDataModel) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = currentCatInteractor.deleteCat(catDataModel)
            withContext(Dispatchers.Main) {
                val ids = mutableListOf<String>()
                result.forEach {
                    ids.add(it.id)
                    Log.d(tag, "cat = ${it.id}")
                }

                _catIdList.postValue(ids)
            }
        }
    }


}