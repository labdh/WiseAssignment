package com.example.wiseassignment.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface drinksAPI {

    @GET("api/json/v1/1/search.php?s=")
    suspend fun getdrinks() : Response<Drinkdto>


//    @GET("api/json/v1/1/search.php?s={strDrink}")
//    suspend fun getdrinkbyname(@Path("strDrink") strDrink:String) : Response<Drink>
}