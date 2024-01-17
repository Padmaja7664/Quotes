package com.example.quotes

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("quotes")
    fun getRandomQuotes(): Call<List<MyDataItem>>
}