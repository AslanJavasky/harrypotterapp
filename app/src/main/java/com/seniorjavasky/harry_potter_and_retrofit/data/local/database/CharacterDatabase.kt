package com.seniorjavasky.harry_potter_and_retrofit.data.local.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.seniorjavasky.harry_potter_and_retrofit.data.local.dao.CharacterDao
import com.seniorjavasky.harry_potter_and_retrofit.data.local.entity.CharacterDbModel
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [CharacterDbModel::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object {
        private var INSTANCE: CharacterDatabase? = null
        private const val DB_NAME = "characters.db"
        private val LOCK = Any()

        fun getInstance(@ApplicationContext application: Application): CharacterDatabase {
            INSTANCE?.let { db ->
                return db
            }

            synchronized(LOCK) {
                INSTANCE?.let { db ->
                    return db
                }
                val db = Room.databaseBuilder(
                    application,
                    CharacterDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}