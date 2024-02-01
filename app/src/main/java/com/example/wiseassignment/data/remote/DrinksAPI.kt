package com.example.wiseassignment.data.remote

import com.example.wiseassignment.data.remote.dto.Drinkdto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface drinksAPI {

    @GET("api/json/v1/1/search.php?s=")
    suspend fun getdrinks() : Response<Drinkdto>


    @GET("api/json/v1/1/search.php")
    suspend fun getdrinkbyID(@Query("s") strDrink:String) : Response<Drinkdto>
}