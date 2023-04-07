package com.seniorjavasky.harry_potter_and_retrofit

import android.app.Application
import androidx.room.Room
import com.seniorjavasky.harry_potter_and_retrofit.data.local.database.CharacterDatabase

class App : Application() {

    lateinit var db: CharacterDatabase

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            CharacterDatabase::class.java,
            "db"
        ).build()
    }

}