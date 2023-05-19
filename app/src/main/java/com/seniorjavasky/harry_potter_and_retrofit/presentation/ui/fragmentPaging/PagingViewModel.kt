package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.repoImpl.CharacterPagingRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetPagerForCharactersUseCase
import kotlinx.coroutines.flow.Flow

class PagingViewModel : ViewModel() {

    val useCase=GetPagerForCharactersUseCase(CharacterPagingRepositoryImpl())

    val items: Flow<PagingData<CharacterPagingItem>> = useCase()
        .flow
        .cachedIn(viewModelScope)


    companion object {
        private const val ITEMS_PER_PAGE = 100
    }
}