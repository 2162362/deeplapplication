package com.example.deeplapp.services

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DeeplApiService {
    fun getService(): DeeplApiInterface {
        return Retrofit.Builder()
            .baseUrl("https://api-free.deepl.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(DeeplApiInterface::class.java);
    }
}