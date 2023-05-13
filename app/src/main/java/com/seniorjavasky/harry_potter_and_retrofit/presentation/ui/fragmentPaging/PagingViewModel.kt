package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.repoImpl.CharacterPagingRepoImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetDataForPagingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PagingViewModel : ViewModel() {

    private val useCase = GetDataForPagingUseCase(CharacterPagingRepoImpl())

    private var _characters =
        MutableStateFlow<List<CharacterPagingItem>>(emptyList())
    val characters = _characters.asStateFlow()

    init {
        viewModelScope.launch {
            _characters.value = useCase().filter { it.name != null && it.imageUrl != null }

        }
    }
}