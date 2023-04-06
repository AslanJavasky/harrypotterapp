package com.seniorjavasky.harry_potter_and_retrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seniorjavasky.harry_potter_and_retrofit.data.network.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterUseCase

class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            val repo=CharacterRepositoryImpl()
            val useCase=GetCharacterUseCase(repo)
            val useCase2=GetCharacterListUseCase(repo)
            return MainViewModel(repo,useCase2,useCase) as T
        }
        throw java.lang.IllegalArgumentException("Unknown class name")
    }

}
