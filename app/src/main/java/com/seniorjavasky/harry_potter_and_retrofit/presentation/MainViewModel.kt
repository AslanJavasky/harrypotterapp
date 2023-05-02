package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seniorjavasky.harry_potter_and_retrofit.data.network.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterModel
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.logging.HttpLoggingInterceptor

private const val TAG = "MainViewModel555"

class MainViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<ProgressState>(ProgressState.Success)
    var state=_state.asStateFlow()

    private var _character = MutableStateFlow<CharacterModel>(CharacterModel())
    var character = _character.asStateFlow()
    private var _characterList = MutableStateFlow<List<CharacterModel>>(mutableListOf())
    var characterList = _characterList.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value=ProgressState.Loading
            try {
                _character.value = getCharacterUseCase()
                _characterList.value = getCharacterListUseCase()
            } catch (t: Throwable) {
                Log.e(TAG, "${t.message}: ", t)
            }
            _state.value=ProgressState.Success
        }
    }

    fun randomCharacter() {
//        _character.value = _characterList.value.random()
        viewModelScope.launch {
            _state.value=ProgressState.Loading
            try {
                val listSize = _characterList.value.size
                _character.value = getCharacterUseCase((1..listSize).random())
            }catch (t: Throwable) {
                Log.e(TAG, "${t.message}: ", t)
            }
            _state.value=ProgressState.Success
        }
    }
}