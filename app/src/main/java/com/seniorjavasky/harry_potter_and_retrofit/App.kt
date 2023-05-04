package com.seniorjavasky.harry_potter_and_retrofit

import android.app.Application
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.data.firebase.FirebaseUtils
import com.seniorjavasky.harry_potter_and_retrofit.data.local.database.CharacterDatabase

class App : Application() {

    lateinit var db: CharacterDatabase
        private set

    lateinit var firebaseInstance: FirebaseUtils
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        db = CharacterDatabase.getInstance(this)
        firebaseInstance = FirebaseUtils.getInstance(this)

        firebaseInstance.crashlytics.setCrashlyticsCollectionEnabled(false)
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }

}