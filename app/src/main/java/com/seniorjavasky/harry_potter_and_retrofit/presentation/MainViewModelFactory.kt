package com.seniorjavasky.harry_potter_and_retrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.CashCharacterUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.UploadListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.UploadCharacterUseCase

class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val repo = CharacterRepositoryImpl(App.INSTANCE)
            val uploadCharacterUseCase=UploadCharacterUseCase(repo)
            val cashCharacterUseCase=CashCharacterUseCase(repo)
            val getCharacterUseCase= GetCharacterUseCase(repo)
            return MainViewModel(uploadCharacterUseCase, cashCharacterUseCase,getCharacterUseCase) as T
        }
        throw RuntimeException("Unknown class name")
    }

}
