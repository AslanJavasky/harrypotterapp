package com.seniorjavasky.harry_potter_and_retrofit.data.local.dao

import androidx.room.*
import com.seniorjavasky.harry_potter_and_retrofit.data.local.entity.CharacterDbModel

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): List<CharacterDbModel>

    @Query("SELECT * FROM characters WHERE id= :id LIMIT 1")
    suspend fun getAllCharacterById(id:Int=1): CharacterDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterItem(character: CharacterDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterList(characters: List<CharacterDbModel>)

    @Query("DELETE FROM characters")
    suspend fun deleteAll()

}