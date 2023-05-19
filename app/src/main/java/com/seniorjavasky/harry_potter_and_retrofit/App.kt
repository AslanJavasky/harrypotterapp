package com.seniorjavasky.harry_potter_and_retrofit

import android.app.Application
import androidx.work.Configuration
import com.seniorjavasky.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.data.firebase.FirebaseUtils
import com.seniorjavasky.harry_potter_and_retrofit.data.local.database.CharacterDatabase
import com.seniorjavasky.harry_potter_and_retrofit.data.mappers.CharacterMapper
import com.seniorjavasky.harry_potter_and_retrofit.di.ApplicationComponent
import com.seniorjavasky.harry_potter_and_retrofit.di.ContextModule
import com.seniorjavasky.harry_potter_and_retrofit.di.DaggerApplicationComponent
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.CashCharacterListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.UploadListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.presentation.worker.CasherDataWorkerFactory
import com.seniorjavasky.harry_potter_and_retrofit.presentation.utils.NotificationUtils
import com.seniorjavasky.harry_potter_and_retrofit.presentation.utils.PermissionUtils
import dagger.Component
import javax.inject.Inject

class App : Application(), Configuration.Provider {

    lateinit var db: CharacterDatabase
        private set

    @Inject
    lateinit var appComponent: ApplicationComponent

    @Inject
    lateinit var firebaseInstance: FirebaseUtils

    lateinit var notificationService: NotificationUtils
        private set

    lateinit var permissionService: PermissionUtils
        private set


    override fun onCreate() {
        super.onCreate()

        INSTANCE = this

        DaggerApplicationComponent.factory().create(this).inject(this)

        permissionService = PermissionUtils.getInstance(this)
        db = CharacterDatabase.getInstance(this)

        firebaseInstance.crashlytics.setCrashlyticsCollectionEnabled(false)

        notificationService = NotificationUtils.getInstance(this)
        notificationService.createNotificationChannel()


    }


    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(appComponent.casherDataWorkerFactory())
            .build()
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}