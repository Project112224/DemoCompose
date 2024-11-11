package com.example.demokotlin.model.api

import com.example.demokotlin.model.api.service.CategoriesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val API_PATH = "https://www.themealdb.com/api/json/v1/1/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(API_PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getCategoriesService: CategoriesService by lazy {
        retrofit.create(CategoriesService::class.java)
    }
}