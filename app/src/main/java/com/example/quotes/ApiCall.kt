package com.example.quotes

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCall {

    fun getRandomQuotes(callback :(List<MyDataItem>?) -> Unit){
        val retrofit= Retrofit.Builder()
            .baseUrl("https://type.fit/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitdata = retrofit.getRandomQuotes()

        retrofitdata.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {

                if(response.isSuccessful){
                    val quoteslist : List<MyDataItem>? = response.body()
                    callback(quoteslist)
                }
                else{
                    callback(null)
                }

            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                callback(null)
            }

        })


    }
}

private fun <T> Call<T>.enqueue(callback: Callback<MyDataItem?>) {

}

