package com.seniorjavasky.harry_potter_and_retrofit.data.paging.repoImpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.pagingSource.CharacterPagingSource
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterPagingRepository
import javax.inject.Inject


class CharacterPagingRepositoryImpl @Inject constructor(
    private val pagingSource: CharacterPagingSource
) : CharacterPagingRepository {


    override fun getPager() = Pager(
        config = PagingConfig(ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { pagingSource }
    )

    companion object {
        private const val ITEMS_PER_PAGE = 100
    }
}