package com.seniorjavasky.harry_potter_and_retrofit

import android.app.Application
import androidx.room.Room
import com.seniorjavasky.harry_potter_and_retrofit.data.local.database.CharacterDatabase

class App : Application() {

    lateinit var db: CharacterDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        db = Room
            .inMemoryDatabaseBuilder(
                this,
                CharacterDatabase::class.java,
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }

}