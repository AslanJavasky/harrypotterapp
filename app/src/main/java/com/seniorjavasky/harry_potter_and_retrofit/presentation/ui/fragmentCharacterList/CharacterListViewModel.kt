package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacterList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

private const val TAG = "CharacterListViewModel"

class CharacterListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : ViewModel() {

    private var _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    val onlySlytherin = MutableStateFlow(false)

    private var _characterList = MutableStateFlow<List<CharacterItem>>(mutableListOf())
    val characterList: StateFlow<List<CharacterItem>> =
        combine(_characterList, onlySlytherin) { characters, onlySlytherin ->
            if (onlySlytherin) {
                characters.filter { it.hogwartsHouse == "Slytherin" }
            } else {
                characters
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = _characterList.value
        )

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            kotlin.runCatching {
                getCharacterListUseCase()
            }.fold(
                onSuccess = { _characterList.value = it },
                onFailure = { Log.e(TAG, "${it.message}", it) }
            )
            _isLoading.value = false
        }
    }

    fun refresh() {
        getCharacters()
    }

}