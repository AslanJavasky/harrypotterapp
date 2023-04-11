package com.seniorjavasky.harry_potter_and_retrofit.presentation

import androidx.lifecycle.ViewModel
import com.seniorjavasky.harry_potter_and_retrofit.data.network.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterListUseCase

class CharacterListViewModel : ViewModel() {

    val repository=CharacterRepositoryImpl
    val getCharacterListUseCase=GetCharacterListUseCase(repository)


}