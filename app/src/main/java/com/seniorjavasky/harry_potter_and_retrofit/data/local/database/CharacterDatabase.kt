package com.seniorjavasky.harry_potter_and_retrofit.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seniorjavasky.harry_potter_and_retrofit.data.local.dao.CharacterDao
import com.seniorjavasky.harry_potter_and_retrofit.data.local.entity.Book
import com.seniorjavasky.harry_potter_and_retrofit.data.local.entity.CharacterDb
import com.seniorjavasky.harry_potter_and_retrofit.data.local.entity.WandDb

@Database(entities = [CharacterDb::class, WandDb::class, Book::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}