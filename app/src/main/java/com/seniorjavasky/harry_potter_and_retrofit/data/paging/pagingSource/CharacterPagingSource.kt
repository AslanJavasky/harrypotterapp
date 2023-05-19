package com.seniorjavasky.harry_potter_and_retrofit.data.paging.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.api.RetrofitInstance
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.mapper.CharacterPagingMapper
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem
import javax.inject.Inject
import kotlin.math.max
import kotlin.math.min

class CharacterPagingSource @Inject constructor(
    private val mapper : CharacterPagingMapper
) : PagingSource<Int, CharacterPagingItem>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, CharacterPagingItem> {

        val page = params.key ?: STARTING_KEY
        val range = (page..LAST_PAGE)


        return kotlin.runCatching {
            mapper.mapDtoPagingToItemPaging(
                RetrofitInstance.searchCharactersApi.getCharacters(page).data
            )
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (page == LAST_PAGE) null else ensureValidKey( page + 1)
                )
            },
            onFailure = { LoadResult.Error(it) }
        )
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterPagingItem>): Int {
        return STARTING_KEY
    }

    private fun ensureValidKey(key: Int) = min(max(STARTING_KEY, key), LAST_PAGE)

    companion object {
        private const val STARTING_KEY = 1
        private const val LAST_PAGE = 41
    }
}