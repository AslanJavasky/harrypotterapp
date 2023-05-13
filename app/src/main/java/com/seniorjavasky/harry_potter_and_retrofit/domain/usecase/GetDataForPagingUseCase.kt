package com.seniorjavasky.harry_potter_and_retrofit.domain.usecase

import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterPagingRepository

class GetDataForPagingUseCase(
    private val repo: CharacterPagingRepository
) {
    suspend operator fun invoke(): List<CharacterPagingItem> {
        return repo.getCharacters()
    }
}