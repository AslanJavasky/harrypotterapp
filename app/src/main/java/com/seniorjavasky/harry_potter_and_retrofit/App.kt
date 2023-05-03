package com.seniorjavasky.harry_potter_and_retrofit

import android.app.Application
import androidx.room.Room
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.seniorjavasky.harry_potter_and_retrofit.data.local.database.CharacterDatabase
import com.seniorjavasky.harry_potter_and_retrofit.data.local.migration.MIGRATION_1_2
import com.seniorjavasky.harry_potter_and_retrofit.data.local.migration.MIGRATION_2_3

class App : Application() {

    lateinit var db: CharacterDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(
            false
        )

        INSTANCE = this

        db=CharacterDatabase.getInstance(this)
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }

}