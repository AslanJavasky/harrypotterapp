package com.seniorjavasky.harry_potter_and_retrofit

import android.app.Application
import android.os.Build
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import com.seniorjavasky.harry_potter_and_retrofit.data.firebase.FirebaseUtils
import com.seniorjavasky.harry_potter_and_retrofit.data.local.database.CharacterDatabase
import com.seniorjavasky.harry_potter_and_retrofit.presentation.NotificationUtils
import com.seniorjavasky.harry_potter_and_retrofit.presentation.PermissionUtils

class App : Application() {

    lateinit var db: CharacterDatabase
        private set

    lateinit var firebaseInstance: FirebaseUtils
        private set

    lateinit var notificationService: NotificationUtils
        private set

    lateinit var permissionService: PermissionUtils
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        permissionService=PermissionUtils.getInstance(this)
        db = CharacterDatabase.getInstance(this)
        firebaseInstance = FirebaseUtils.getInstance(this)

        firebaseInstance.crashlytics.setCrashlyticsCollectionEnabled(false)

        notificationService=NotificationUtils.getInstance(this)
        notificationService.createNotificationChannel()


    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }

}