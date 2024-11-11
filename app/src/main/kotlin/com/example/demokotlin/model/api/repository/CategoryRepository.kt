package com.example.demokotlin.model.api.repository

import com.example.demokotlin.model.api.RetrofitInstance
import com.example.demokotlin.model.api.datas.Categories
import retrofit2.Call

class CategoryRepository {

    private val service = RetrofitInstance.getCategoriesService

    fun getCategories(): Call<Categories> {
        return service.getCategories()
    }
}