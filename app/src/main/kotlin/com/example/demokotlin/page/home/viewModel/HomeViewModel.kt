package com.example.demokotlin.page.home.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demokotlin.model.api.datas.Categories
import com.example.demokotlin.model.api.repository.CategoryRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val categoryRepository = CategoryRepository()

    val categories = mutableStateOf(Categories(categories = arrayListOf()))

    fun fetchCategories() {
        viewModelScope.launch {
            val getCategories = categoryRepository.getCategories()
            getCategories.enqueue(object : Callback<Categories> {
                override fun onFailure(call: Call<Categories>, t: Throwable) {
                    Log.v("HomeViewModel", "Error: ${t.message}")
                }

                override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                    if (response.isSuccessful) {
                        val data = response.body()!!
                        categories.value = data
                    }
                }
            })
        }
    }

}