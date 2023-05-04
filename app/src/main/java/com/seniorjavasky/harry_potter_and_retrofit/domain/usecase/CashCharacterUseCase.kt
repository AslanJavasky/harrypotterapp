package com.seniorjavasky.harry_potter_and_retrofit.domain.usecase

import com.seniorjavasky.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository

class CashCharacterUseCase(
    private val repo: CharacterRepository
) {
    suspend operator fun invoke(characterItem: CharacterItem) =
        repo.saveCharacterToDb(characterItem)
}