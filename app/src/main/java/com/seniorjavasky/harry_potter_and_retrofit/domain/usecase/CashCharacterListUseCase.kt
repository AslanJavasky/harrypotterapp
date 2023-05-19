package com.seniorjavasky.harry_potter_and_retrofit.domain.usecase

import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository
import javax.inject.Inject

class CashCharacterListUseCase @Inject constructor(
    private val repo: CharacterRepository
) {
    suspend operator fun invoke(characters: List<CharacterItem>) =
        repo.saveCharacterListToDb(characters)
}