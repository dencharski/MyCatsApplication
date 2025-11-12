package com.example.mycatsapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {
    private val _mutableSelectedItem = MutableLiveData<String>()
    val selectedItem: LiveData<String> get() = _mutableSelectedItem

    fun selectItem(string: String) {
        _mutableSelectedItem.value = string
    }
}