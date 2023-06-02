package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainViewModel555"

class MainViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<ProgressState>(ProgressState.Success)
    var state = _state.asStateFlow()

    private var _character = MutableStateFlow<CharacterItem>(CharacterItem())
    var character = _character.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = ProgressState.Loading
            try {
                _character.value = getCharacterUseCase()
            } catch (t: Throwable) {
                Log.e(TAG, "${t.message}: ", t)
            }
            _state.value = ProgressState.Success
        }
    }

    fun randomCharacter() {
        viewModelScope.launch {
            kotlin.runCatching {
                _state.value = ProgressState.Loading
                getCharacterUseCase((1..23).random())
            }.fold(
                onSuccess = { _character.value = it },
                onFailure = { Log.e(TAG, "${it.message}: ", it) }
            )
            _state.value = ProgressState.Success
        }
    }
}