package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterUseCase

class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val repo = CharacterRepositoryImpl(App.INSTANCE)
            val getCharacterUseCase= GetCharacterUseCase(repo)
            return MainViewModel(getCharacterUseCase) as T
        }
        throw RuntimeException("Unknown class name")
    }

}
