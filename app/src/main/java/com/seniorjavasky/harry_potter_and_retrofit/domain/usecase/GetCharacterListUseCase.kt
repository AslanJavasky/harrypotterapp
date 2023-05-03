package com.seniorjavasky.harry_potter_and_retrofit.domain.usecase

import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository

class GetCharacterListUseCase(
    private val repo: CharacterRepository
) {
    suspend operator fun invoke() = repo.getCharacters()
}