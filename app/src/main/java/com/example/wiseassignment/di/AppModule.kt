package com.example.wiseassignment.di

import com.example.wiseassignment.common.Constant
import com.example.wiseassignment.data.remote.drinksAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesDrinksAPI(retrofit: Retrofit) : drinksAPI {
        return retrofit.create(drinksAPI::class.java)
    }
}