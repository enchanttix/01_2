package com.example.training.Api

import com.example.training.Model.Films
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("api/Movie")
    fun getsMovie(): Call<List<Films>>
}