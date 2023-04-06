package com.seniorjavasky.harry_potter_and_retrofit.data.network

import com.seniorjavasky.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository
import com.seniorjavasky.harry_potter_and_retrofit.data.network.mapper.CharacterMapper
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterModel

class CharacterRepositoryImpl : CharacterRepository {

    private val mapper=CharacterMapper()

    override suspend fun getCharacters(): List<CharacterModel> {
        return mapper.mapListDtoToListModel(
            RetrofitInstance.searchCharactersApi.getCharacters()
        )
    }
    override suspend fun getCharacterById(id: Int): CharacterModel {
        return mapper.mapDtoToModel(
            RetrofitInstance.searchCharactersApi.getCharacterById(id)
        )
    }
}

