package com.example.deeplapp.services

import com.example.deeplapp.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DeeplApiService {
    fun getService(): DeeplApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.DEEPL_API_DOMAIN_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(DeeplApiInterface::class.java);
    }
}