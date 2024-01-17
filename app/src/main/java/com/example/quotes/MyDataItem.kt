package com.example.quotes


import com.google.gson.annotations.SerializedName

data class MyDataItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("text")
    val text: String
)