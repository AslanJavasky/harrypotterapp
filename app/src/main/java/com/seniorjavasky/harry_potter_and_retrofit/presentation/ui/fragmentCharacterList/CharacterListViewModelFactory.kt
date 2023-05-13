package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacterList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterListUseCase

class CharacterListViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterListViewModel::class.java)) {
            val repo = CharacterRepositoryImpl(App.INSTANCE)
            val getCharacterListUseCase = GetCharacterListUseCase(repo)
            return CharacterListViewModel(
                getCharacterListUseCase
            ) as T
        }
        throw RuntimeException("Unknown class name")
    }

}