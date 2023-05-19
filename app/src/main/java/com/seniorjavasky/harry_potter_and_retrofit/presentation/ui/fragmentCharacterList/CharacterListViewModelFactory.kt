package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacterList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class CharacterListViewModelFactory @Inject constructor(
    private val characterListViewModel: CharacterListViewModel
    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterListViewModel::class.java)) {
            return characterListViewModel as T
        }
        throw RuntimeException("Unknown class name")
    }

}