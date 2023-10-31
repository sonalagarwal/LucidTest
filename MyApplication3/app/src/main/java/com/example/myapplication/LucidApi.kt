package com.example.myapplication

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface LucidApi {

    @GET(".")
    suspend fun getPhotos() : List<Photos>
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/photos/")
    .addConverterFactory(GsonConverterFactory.create(Gson()))
    .build()