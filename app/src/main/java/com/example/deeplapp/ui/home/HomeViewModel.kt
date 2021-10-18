package com.example.deeplapp.ui.home

import androidx.databinding.Observable
import androidx.lifecycle.*
import com.example.deeplapp.models.Language
import com.example.deeplapp.services.repositories.DeeplRepository
import com.example.deeplapp.util.ObservableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    deeplRepository: DeeplRepository
) : ObservableViewModel() {

    private val _languageListSource = MutableLiveData<List<Language>>()
    val languageListSource: LiveData<List<Language>> get() = _languageListSource

    private val _languageListSourceSelected = MutableLiveData<Int>()
    val languageListSourceSelected : LiveData<Int> get() = _languageListSourceSelected

    init {
        viewModelScope.launch {
            _languageListSource.postValue(deeplRepository.getLanguages())
            _languageListSourceSelected.postValue(0)
        }
    }
}