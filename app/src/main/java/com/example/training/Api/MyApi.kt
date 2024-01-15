package com.example.training.Api

import com.example.training.Model.Films
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MyApi {
    @GET("api/Movie")
    fun getsMovie(): Call<List<Films>>
    @POST("api/SendCode")
    fun postEmail(@Header("User-email") email: String): Call<String>
    @POST("api/SignIn")
    fun signIn(@Header("User-email") email: String, @Header("User-code") code: String): Call<String>
}