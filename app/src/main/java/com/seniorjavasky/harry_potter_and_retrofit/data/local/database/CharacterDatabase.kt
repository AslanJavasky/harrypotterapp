package com.seniorjavasky.harry_potter_and_retrofit.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seniorjavasky.harry_potter_and_retrofit.data.local.dao.CharacterDao
import com.seniorjavasky.harry_potter_and_retrofit.data.local.entity.CharacterDb

@Database(entities = [CharacterDb::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}