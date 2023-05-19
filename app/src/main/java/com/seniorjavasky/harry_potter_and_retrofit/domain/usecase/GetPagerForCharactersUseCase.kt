package com.seniorjavasky.harry_potter_and_retrofit.domain.usecase

import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterPagingRepository
import javax.inject.Inject

class GetPagerForCharactersUseCase @Inject constructor(
    private val repo: CharacterPagingRepository
) {

    operator fun invoke()=repo.getPager()
}