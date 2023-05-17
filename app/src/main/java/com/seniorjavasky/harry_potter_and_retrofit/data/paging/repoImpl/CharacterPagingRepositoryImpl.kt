package com.seniorjavasky.harry_potter_and_retrofit.data.paging.repoImpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.pagingSource.CharacterPagingSource
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterPagingRepository


class CharacterPagingRepositoryImpl : CharacterPagingRepository {


    override fun getPager() = Pager(
        config = PagingConfig(ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { CharacterPagingSource() }
    )

    companion object {
        private const val ITEMS_PER_PAGE = 100
    }
}