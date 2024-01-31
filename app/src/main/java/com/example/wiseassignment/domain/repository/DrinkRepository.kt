package com.example.wiseassignment.domain.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wiseassignment.data.remote.Drink
import com.example.wiseassignment.data.remote.Drinkdto
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

//    private val _drinksdetail = MutableLiveData<Drink>()
//    val productsDetail: LiveData<Drink>
//        get() = _drinksdetail
//    suspend fun getProductDetail(strname:String){
//        val result2 = drinkAPI.getdrinkbyname(strname)
//        if(result2.isSuccessful && result2.body() != null){
//            _drinksdetail.postValue(result2.body())
//        }
//    }

}