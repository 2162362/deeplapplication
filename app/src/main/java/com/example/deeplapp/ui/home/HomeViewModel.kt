package com.example.deeplapp.ui.home

import androidx.lifecycle.*
import com.example.deeplapp.models.Language
import com.example.deeplapp.services.repositories.DeeplRepository
import com.example.deeplapp.util.Constants
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

    private val _languageListSourceSelected = MutableLiveData<Int>()
    val languageListSourceSelected : LiveData<Int> get() = _languageListSourceSelected

    private  val _languageListDestination = MutableLiveData<List<Language>>()
    val languageListDestination: LiveData<List<Language>> get() = _languageListDestination

    private val _languageListDestinationSelected = MutableLiveData<Int>()
    val languageListDestinationSelected : LiveData<Int> get() = _languageListDestinationSelected

    init {
        viewModelScope.launch {
            _languageListSource.postValue(deeplRepository.getLanguages(Constants.DEEPL_LANG_SOURCE_FIELD))
            _languageListSourceSelected.postValue(0)

            _languageListDestination.postValue(deeplRepository.getLanguages(Constants.DEEPL_LANG_TARGET_FIELD))
            _languageListSourceSelected.postValue(0)
        }
    }
}