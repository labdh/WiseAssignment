package com.example.wiseassignment.presentation.drinkdetail.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.wiseassignment.R
import com.example.wiseassignment.presentation.drinkdetail.Viewmodel.DrinkdetailVM

class ProductDetails : AppCompatActivity() {
    lateinit var strDrink : TextView
    lateinit var strcategory : TextView
    lateinit var strimage : ImageView
    lateinit var strmeasure : TextView
    lateinit var stringre : TextView
    lateinit var strinstr : TextView
    var measure_str: String =""
    var ingredient_str: String =""
    var instruction_str: String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        strDrink = findViewById(R.id.product_name)
        strmeasure = findViewById(R.id.product_measures)
        strcategory = findViewById(R.id.product_category)
        strimage = findViewById(R.id.product_image)
        strinstr = findViewById(R.id.product_instructions)
        stringre = findViewById(R.id.product_ingredients)
        setdetails()
    }

    private fun setdetails(){
        val bundle: Bundle? = intent.extras
        if(bundle != null){
            strDrink.text = bundle.getString("strname")
            strcategory.text = bundle.getString("strcategory")
            if(bundle.getString("strthumb")!=null) Glide.with(this).load(bundle.getString("strthumb")).into(strimage)
            val stringMeasure = bundle.getStringArrayList("measure")
            if (stringMeasure != null) {
                for(it in stringMeasure) measure_str += it+','.toString()
            }
            val stringIngredient = bundle.getStringArrayList("ingredient")
            if (stringIngredient != null) {
                for(it in stringIngredient) ingredient_str += it+','.toString()
            }
            val stringinstruction = bundle.getStringArrayList("instruction")
            if (stringinstruction != null) {
                var temp = 1
                for(it in stringinstruction) {
                    instruction_str += "${temp}) "+it+'\n'.toString()
                    temp++
                }
            }
            strmeasure.text = measure_str
            stringre.text = ingredient_str
            strinstr.text = instruction_str
        }
    }
}