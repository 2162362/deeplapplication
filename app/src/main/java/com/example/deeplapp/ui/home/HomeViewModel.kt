package com.example.deeplapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deeplapp.models.Language
import com.example.deeplapp.services.DeeplApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val service : DeeplApiService = DeeplApiService()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val languageListSource: MutableLiveData<List<Language>> by lazy {
        MutableLiveData<List<Language>>().also {
            loadLanguages()
        }
    }

    fun getSourceLanguages(): LiveData<List<Language>>{
        return languageListSource
    }

    private val languageListDest: MutableLiveData<List<Language>> by lazy {
        MutableLiveData<List<Language>>()
    }

    fun getDestinationLanguages() : LiveData<List<Language>>{
        return languageListDest
    }

    fun setDestinationLanguages(newList : List<Language>) : MutableLiveData<List<Language>>{
        languageListDest.value = newList
        return languageListDest
    }

    private fun loadLanguages() {
        service
            .getService()
            .getLanguages(authKey = "f5d6f0b1-225a-be1d-40a9-ee8f616229ef:fx", languageListing = "source")
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
                        languageListSource.value = list
                    }
                }
            })
    }


}