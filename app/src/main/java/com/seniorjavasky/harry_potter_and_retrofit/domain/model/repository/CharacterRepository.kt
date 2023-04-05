package com.seniorjavasky.harry_potter_and_retrofit.domain.model.repository

interface CharacterRepository {
    fun getCharacters()
    fun getCharacterById(id:Int)
}