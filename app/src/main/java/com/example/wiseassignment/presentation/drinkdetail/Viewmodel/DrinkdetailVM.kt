package com.example.wiseassignment.presentation.drinkdetail.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wiseassignment.data.remote.dto.Drinkdto
import com.example.wiseassignment.domain.repository.DrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkdetailVM @Inject constructor(private val repository: DrinkRepository ) : ViewModel() {

    val productsLiveData : LiveData<Drinkdto> = repository.productsDetail

     fun getDrinkbyId(id : String) {
         viewModelScope.launch {
             repository.getProductDetail(id)
         }
     }

}

