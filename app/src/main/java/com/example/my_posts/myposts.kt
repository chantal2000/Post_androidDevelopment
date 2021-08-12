package com.example.my_posts
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object myposts {
    var retrofit=Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> buildService(APIInterface:Class<T>):T{
        return retrofit.create(APIInterface)
    }
}