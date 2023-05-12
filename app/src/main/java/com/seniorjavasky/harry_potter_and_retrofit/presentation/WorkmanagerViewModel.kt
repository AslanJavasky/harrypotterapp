package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.lessons.HatWorker
import com.seniorjavasky.harry_potter_and_retrofit.presentation.worker.CasherDataWorker

class WorkmanagerViewModel(
    val context: Application
) : ViewModel() {

    init {
        CasherDataWorker.start()
    }

    fun testNotify() {
        (context as App).notificationService.createNotification()
    }

    fun startService() {
        CasherDataWorker.start()
    }

    fun stopService() {
        CasherDataWorker.stop()
    }


}