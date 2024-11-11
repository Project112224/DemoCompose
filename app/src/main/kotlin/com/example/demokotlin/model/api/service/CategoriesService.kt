package com.example.demokotlin.model.api.service

import com.example.demokotlin.model.api.datas.Categories
import retrofit2.Call
import retrofit2.http.GET

interface  CategoriesService {
    @GET("categories.php")
    fun getCategories(): Call<Categories>
}