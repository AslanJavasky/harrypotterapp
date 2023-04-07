package com.seniorjavasky.harry_potter_and_retrofit.data.local.dao

import androidx.room.*
import com.seniorjavasky.harry_potter_and_retrofit.data.local.entity.CharacterDb
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character")
    suspend fun getAll(): List<CharacterDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterDb: CharacterDb)

    @Update
    suspend fun update(characterDb: CharacterDb)

    @Delete
    suspend fun delete(characterDb: CharacterDb)

}