package com.example.wiseassignment.presentation.drinkdetail.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wiseassignment.data.remote.Drink
import com.example.wiseassignment.data.remote.Drinkdto
import com.example.wiseassignment.domain.repository.DrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import kotlin.collections.get



class DrinkdetailVM {

//    fun getdata(strname:String) : LiveData<Drink>{
//        viewModelScope.launch {
//            repository.getProductDetail(strname = strname)
//        }
//        val productDetailLiveData : LiveData<Drink> = repository.productsDetail
//        return productDetailLiveData
//    }
//    val productDetailLiveData : LiveData<Drink>
//        get() = repository.productsDetail
//
//    init {
//        viewModelScope.launch {
//            repository.getProductDetail("mojito")
//        }
//    }

}

