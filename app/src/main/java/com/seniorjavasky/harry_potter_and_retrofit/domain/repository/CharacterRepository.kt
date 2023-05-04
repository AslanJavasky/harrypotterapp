package com.seniorjavasky.harry_potter_and_retrofit.domain.repository

import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem

interface CharacterRepository {
    //Network
    suspend fun getCharactersFromNetwork(): List<CharacterItem>
    suspend fun getCharacterByIdFromNetwork(id:Int):CharacterItem
    //Local
    suspend fun saveCharacterToDb(characterItem: CharacterItem)
    suspend fun saveCharacterListToDb(characterList: List<CharacterItem>)
    suspend fun getCharactersFromDb(): List<CharacterItem>
    suspend fun getCharacterByIdFromDb(id:Int):CharacterItem

}