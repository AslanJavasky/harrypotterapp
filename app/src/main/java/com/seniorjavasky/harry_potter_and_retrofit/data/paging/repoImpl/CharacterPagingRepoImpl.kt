package com.seniorjavasky.harry_potter_and_retrofit.data.paging.repoImpl

import com.seniorjavasky.harry_potter_and_retrofit.data.paging.api.RetrofitInstance
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.mapper.CharacterPagingMapper
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterPagingRepository

class CharacterPagingRepoImpl:CharacterPagingRepository {

    val mapper=CharacterPagingMapper()

    override suspend fun getCharacters(): List<CharacterPagingItem> {
        return mapper.mapDtoPagingToItemPaging(
            RetrofitInstance.searchCharactersApi.getCharacters().data
        )
    }

}