package com.seniorjavasky.harry_potter_and_retrofit

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.seniorjavasky.harry_potter_and_retrofit.data.firebase.FirebaseUtils
import com.seniorjavasky.harry_potter_and_retrofit.data.local.database.CharacterDatabase
import com.seniorjavasky.harry_potter_and_retrofit.presentation.utils.NotificationUtils
import com.seniorjavasky.harry_potter_and_retrofit.presentation.utils.PermissionUtils
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application(), Configuration.Provider {

    lateinit var db: CharacterDatabase
        private set

    @Inject
    lateinit var firebaseInstance: FirebaseUtils

    lateinit var notificationService: NotificationUtils
        private set

    lateinit var permissionService: PermissionUtils
        private set
    @Inject
    lateinit var CasherDataWorkerFactory:HiltWorkerFactory


    override fun onCreate() {
        super.onCreate()

        INSTANCE = this


        permissionService = PermissionUtils.getInstance(this)
        db = CharacterDatabase.getInstance(this)

        firebaseInstance.crashlytics.setCrashlyticsCollectionEnabled(false)

        notificationService = NotificationUtils.getInstance(this)
        notificationService.createNotificationChannel()


    }


    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(CasherDataWorkerFactory)
            .build()
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}