package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.data.local.dao.CharacterDao
import com.seniorjavasky.harry_potter_and_retrofit.data.local.entity.CharacterDb
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DbViewModel : ViewModel() {

    private lateinit var characterDao: CharacterDao

    private var _characters = MutableStateFlow<List<CharacterDb>>(mutableListOf())
    val characters = _characters.asStateFlow()

//    val characters=characterDao.getAll()
//    .stateIn(
//        scope=viewModelScope,
//        started = SharingStarted.WhileSubscribed(500L),
//        initialValue = mutableListOf()
//    )

    fun onBtnAdd() {
        var size = _characters.value.size
        size++
        viewModelScope.launch {
//            characterDao.insert(
//                CharacterDb(id = size, name = "Potter ${size}")
//            )
//            updateTextView()
        }
    }

    fun initDao(application: Application?) {
        characterDao = (application as App).db.characterDao()
    }

    fun onDeleteBtn() {
        viewModelScope.launch {
            characters.value.lastOrNull()?.let {
                characterDao.delete(it)
            }
        }
        updateTextView()
    }

    fun onUpdateBtn() {
        viewModelScope.launch {
            characters.value.lastOrNull()?.let {
                characterDao.update(it.copy(name = "Albus"))
            }
        }
        updateTextView()
    }

    private fun updateTextView() {
//        viewModelScope.launch {
//            _characters.value = characterDao.getAll()
//        }
    }

}