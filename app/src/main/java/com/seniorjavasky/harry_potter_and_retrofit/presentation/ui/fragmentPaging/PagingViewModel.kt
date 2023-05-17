package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.repoImpl.CharacterPagingRepository
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem
import kotlinx.coroutines.flow.Flow

class PagingViewModel : ViewModel() {

    val repo = CharacterPagingRepository()

    val items: Flow<PagingData<CharacterPagingItem>> = Pager(
        config = PagingConfig(ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { repo.characterPagingSource() }
    )
        .flow
        .cachedIn(viewModelScope)


    companion object {
        private const val ITEMS_PER_PAGE = 100
    }
}