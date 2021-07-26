package com.example.deeplapp.services.repositories

import android.util.Log
import com.example.deeplapp.services.DeeplApiService
import com.example.deeplapp.models.Language
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeeplRepository {
    private val service : DeeplApiService = DeeplApiService()

    suspend fun getLanguages() : List<Language> {
        var languageList = listOf<Language>()
        service
            .getService()
            .getLanguages(
                authKey = "f5d6f0b1-225a-be1d-40a9-ee8f616229ef:fx",
                languageListing = "source"
            )
            .enqueue(object : Callback<List<Language>> {
                override fun onFailure(call: Call<List<Language>>, t: Throwable){
                    Log.d("TAG_", "An error happened!")
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<List<Language>>, response: Response<List<Language>>){
                    if (!response.isSuccessful){
                        Log.e("RETROFIT_ERROR", response.code().toString())
                    }
                    val list = response.body()
                    if (list != null){
                        languageList = list
                    }
                }
            })
        return languageList
    }
}