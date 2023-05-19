package com.seniorjavasky.harry_potter_and_retrofit.data

import android.app.Application
import com.seniorjavasky.harry_potter_and_retrofit.data.local.dao.CharacterDao
import com.seniorjavasky.harry_potter_and_retrofit.data.local.database.CharacterDatabase
import com.seniorjavasky.harry_potter_and_retrofit.data.network.RetrofitInstance
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository
import com.seniorjavasky.harry_potter_and_retrofit.data.mappers.CharacterMapper
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val mapper: CharacterMapper,
    private val characterDao: CharacterDao
) : CharacterRepository {

    //Network
    override suspend fun getCharactersFromNetwork(): List<CharacterItem> {
        return mapper.mapListDtoToListModel(
            RetrofitInstance.searchCharactersApi.getCharacters()
        )
    }

    override suspend fun getCharacterByIdFromNetwork(id: Int): CharacterItem {
        return mapper.mapDtoToModel(
            RetrofitInstance.searchCharactersApi.getCharacterById(id)
        )
    }

    //Local Room Database
    override suspend fun saveCharacterToDb(characterItem: CharacterItem) {
        characterDao.insertCharacterItem(
            mapper.mapModelToDbModel(characterItem)
        )
    }

    override suspend fun saveCharacterListToDb(characterList: List<CharacterItem>) {
        characterDao.insertCharacterList(
            mapper.mapModelListToDbModelList(characterList)
        )
    }

    override suspend fun getCharactersFromDb(): List<CharacterItem> {
        return mapper.mapDbModelListToModelList(characterDao.getAllCharacters())
    }

    override suspend fun getCharacterByIdFromDb(id: Int): CharacterItem {
        return mapper.mapDbModelToModel(characterDao.getAllCharacterById(id))
    }
}

