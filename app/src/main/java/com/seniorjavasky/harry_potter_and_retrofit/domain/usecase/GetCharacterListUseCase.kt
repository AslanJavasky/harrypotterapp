package com.seniorjavasky.harry_potter_and_retrofit.domain.usecase

import com.seniorjavasky.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterModel
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository

class GetCharacterListUseCase(
    private val repo:CharacterRepository
) {
    suspend fun getCharacterList(): List<CharacterModel> {
        return repo.getCharacters()
    }
}