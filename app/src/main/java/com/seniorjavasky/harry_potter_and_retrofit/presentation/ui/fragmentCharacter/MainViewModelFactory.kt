package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.data.mappers.CharacterMapper
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val mainViewModel: MainViewModel
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return mainViewModel as T
        }
        throw RuntimeException("Unknown class name")
    }

}
