package com.example.wiseassignment.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wiseassignment.data.remote.dto.Drinkdto
import com.example.wiseassignment.data.remote.drinksAPI
import javax.inject.Inject

class DrinkRepository @Inject constructor(private val drinkAPI: drinksAPI) {

    private val _drinks = MutableLiveData<Drinkdto>()
    val products: LiveData<Drinkdto>
        get() = _drinks

    suspend fun getProducts(){
        val result1 = drinkAPI.getdrinks()
        if(result1.isSuccessful && result1.body() != null){
            _drinks.postValue(result1.body())
        }
    }

    private val _drinksdetail = MutableLiveData<Drinkdto>()
    val productsDetail: LiveData<Drinkdto>
        get() = _drinksdetail
    suspend fun getProductDetail(id:String){
        val result2 = drinkAPI.getdrinkbyID(id)
        if(result2.isSuccessful && result2.body() != null){
            _drinksdetail.postValue(result2.body())
        }
    }

}