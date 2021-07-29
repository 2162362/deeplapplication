package com.example.deeplapp.ui.home

import androidx.lifecycle.*
import com.example.deeplapp.models.Language
import com.example.deeplapp.services.repositories.DeeplRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    deeplRepository: DeeplRepository
) : ViewModel() {

    private val languageListSource = MutableLiveData<List<Language>>()

    init {
        viewModelScope.launch {
            languageListSource.value = deeplRepository.getLanguages()
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

}