package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.app.Application
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import androidx.core.app.JobIntentService
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.lessons.HatIntentService
import com.seniorjavasky.harry_potter_and_retrofit.lessons.HatJobIntentService
import com.seniorjavasky.harry_potter_and_retrofit.lessons.MyJobService
import com.seniorjavasky.harry_potter_and_retrofit.lessons.SortingHatForegroundService

class DbViewModel(
    val context: Application
) : ViewModel() {

    fun testNotify() {
        (context as App).notificationService.createNotification()
    }

    fun startService() {
        HatJobIntentService.enqueueWork(context)
    }

    fun stopService() {
        context.stopService(SortingHatForegroundService.getIntent(context))
    }


}