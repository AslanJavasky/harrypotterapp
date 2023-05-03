package com.seniorjavasky.harry_potter_and_retrofit.data.network

import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository
import com.seniorjavasky.harry_potter_and_retrofit.data.network.mapper.CharacterMapper
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem

object CharacterRepositoryImpl : CharacterRepository {

    private val mapper=CharacterMapper()

    override suspend fun getCharacters(): List<CharacterItem> {
        return mapper.mapListDtoToListModel(
            RetrofitInstance.searchCharactersApi.getCharacters()
        )
    }
    override suspend fun getCharacterById(id: Int): CharacterItem {
        return mapper.mapDtoToModel(
            RetrofitInstance.searchCharactersApi.getCharacterById(id)
        )
    }
}

