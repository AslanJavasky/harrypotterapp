package com.seniorjavasky.harry_potter_and_retrofit.domain.repository

import com.seniorjavasky.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterModel

interface CharacterRepository {
    suspend fun getCharacters(): List<CharacterModel>
    suspend fun getCharacterById(id:Int):CharacterModel
}