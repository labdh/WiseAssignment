package com.example.wiseassignment.presentation.drinklist.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wiseassignment.data.remote.Drinkdto
import com.example.wiseassignment.domain.repository.DrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DrinklistVM @Inject constructor(private val repository: DrinkRepository ) : ViewModel() {

    val productsLiveData : LiveData<Drinkdto>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }

}