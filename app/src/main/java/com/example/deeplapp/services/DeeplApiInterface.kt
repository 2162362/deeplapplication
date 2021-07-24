package com.example.deeplapp.services

import com.example.deeplapp.models.Language
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DeeplApiInterface {
    @GET("v2/languages")
    fun getLanguages(@Query("auth_key", encoded = true) authKey: String,
                     @Query("type") languageListing: String): Call<List<Language>>
}