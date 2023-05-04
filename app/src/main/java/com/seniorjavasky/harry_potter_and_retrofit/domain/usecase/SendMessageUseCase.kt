package com.seniorjavasky.harry_potter_and_retrofit.domain.usecase

import com.seniorjavasky.harry_potter_and_retrofit.domain.model.ForumItem
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.ForumRepository

class SendMessageUseCase(
    private val repo:ForumRepository
) {
    operator fun invoke(text: String){
        repo.sendMessage(text)
    }
}