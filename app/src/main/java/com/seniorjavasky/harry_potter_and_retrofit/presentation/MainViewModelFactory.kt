package com.seniorjavasky.harry_potter_and_retrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seniorjavasky.harry_potter_and_retrofit.data.network.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterUseCase

class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val repo = CharacterRepositoryImpl
            val useCase1 = GetCharacterListUseCase(repo)
            val useCase2 = GetCharacterUseCase(repo)
            return MainViewModel(useCase1, useCase2) as T
        }
        throw RuntimeException("Unknown class name")
    }

}
