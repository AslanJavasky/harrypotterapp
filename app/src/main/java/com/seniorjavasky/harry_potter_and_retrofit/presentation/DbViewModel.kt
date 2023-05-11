package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.lessons.HatWorker

class DbViewModel(
    val context: Application
) : ViewModel() {

    fun testNotify() {
        (context as App).notificationService.createNotification()
    }

    fun startService() {
        HatWorker.start(20)
    }

    fun stopService() {
        HatWorker.stop()
    }


}