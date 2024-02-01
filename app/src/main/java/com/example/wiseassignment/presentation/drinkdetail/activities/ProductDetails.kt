package com.example.wiseassignment.presentation.drinkdetail.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.wiseassignment.R
import com.example.wiseassignment.data.remote.dto.toingredient
import com.example.wiseassignment.data.remote.dto.toinstruction
import com.example.wiseassignment.data.remote.dto.tomeasures
import com.example.wiseassignment.databinding.ActivityProductDetailsBinding
import com.example.wiseassignment.domain.model.Detail
import com.example.wiseassignment.presentation.drinkdetail.Viewmodel.DrinkdetailVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetails : AppCompatActivity() {
    lateinit var binding : ActivityProductDetailsBinding
    lateinit var mainViewModel: DrinkdetailVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details)
        mainViewModel = ViewModelProvider(this).get(DrinkdetailVM::class.java)
        setdetails()
    }

    private fun setdetails(){
        val bundle: Bundle? = intent.extras
        if(bundle != null){
            val strDrinkname = bundle.getString("strname")
            if (strDrinkname != null) {
                Log.e("click",strDrinkname)
                setDatabyID(strDrinkname)
            }
        }
    }

    private fun setDatabyID(name:String){
        mainViewModel.getDrinkbyId(name)
        mainViewModel.productsLiveData.observe(this, Observer {
                val strDrink = it.drinks.get(0).strDrink
                val strcategory = it.drinks.get(0).strCategory
                val strthumb = it.drinks.get(0).strDrinkThumb
                val strmeasure = getstring(it.drinks.get(0).tomeasures().arrayList,',')
                val strinstruction = getstring(it.drinks.get(0).toinstruction().arrayList,'\n')
                val stringredient = getstring(it.drinks.get(0).toingredient().arrayList,',')
                val detail = Detail(strthumb,strDrink,strcategory,strmeasure,stringredient,strinstruction)
            Log.e("abcd",detail.toString())
                binding.detail = detail
        })
    }

    private fun getstring(drink:ArrayList<Any>,char : Char):String{
        var array : ArrayList<String> = arrayListOf()
        var string : String =""
        for(m in drink){
            if(m!=null) array.add(m.toString())
        }

        var temp =1
        if (array != null && char == ',') {
            for(it in array) string += it+char
        }
        else if (array != null && char == '\n') {
            for(it in array){
                string += "${temp}) "+it+char
                temp++
            }
        }
        return string
    }
}