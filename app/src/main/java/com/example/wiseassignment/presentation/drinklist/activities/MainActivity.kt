package com.example.wiseassignment.presentation.drinklist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wiseassignment.data.remote.Drink
import com.example.wiseassignment.data.remote.Drinkdto
import com.example.wiseassignment.data.remote.toproduct
import com.example.wiseassignment.databinding.ActivityMainBinding
import com.example.wiseassignment.domain.model.product
import com.example.wiseassignment.presentation.adapters.ProductAdapter
import com.example.wiseassignment.presentation.drinklist.Viewmodel.DrinklistVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: DrinklistVM
    lateinit var binding : ActivityMainBinding
    lateinit var adapter: ProductAdapter
    lateinit var data : ArrayList<Drink>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setDrinks()
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    searchList(newText)
                }
                return false
            }
        })

    }
    private fun setDrinks(){
        mainViewModel = ViewModelProvider(this).get(DrinklistVM::class.java)

        mainViewModel.productsLiveData.observe(this, Observer {
            data = it.drinks as ArrayList<Drink>
            adapter = ProductAdapter(this,data)
            binding.productList.adapter = adapter
            binding.productList.layoutManager = GridLayoutManager(this,2,RecyclerView.VERTICAL,false)
        })
    }

    private fun searchList(text: String){
            val dataSearchList:ArrayList<Drink> = arrayListOf()
            for (data in data){
            if (data.strDrink.toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
            if (dataSearchList.isEmpty()){
                Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
            } else {
                adapter.setSearchList(dataSearchList);
            }
    }
}


