package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.repoImpl.CharacterPagingRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.GetPagerForCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PagingViewModel @Inject constructor(
    private val useCase: GetPagerForCharactersUseCase
) : ViewModel() {

    val items: Flow<PagingData<CharacterPagingItem>> = useCase()
        .flow
        .cachedIn(viewModelScope)

}