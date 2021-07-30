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

    private val _languageListSource = MutableLiveData<List<Language>>()
    val languageListSource: LiveData<List<Language>> get() = _languageListSource

    init {
        viewModelScope.launch {
            _languageListSource.postValue(deeplRepository.getLanguages())
        }
    }
}