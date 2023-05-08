package com.seniorjavasky.harry_potter_and_retrofit.lessons

import android.app.IntentService
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.seniorjavasky.harry_potter_and_retrofit.R
import kotlinx.coroutines.*

private const val TAG = "HatIntentService"

class HatIntentService : IntentService(SERVICE_NAME) {

    private val notification: Notification
        get() = NotificationCompat.Builder(application, CHANNEL_ID)
            .setSmallIcon(R.drawable.sorting_hat_icon)
            .setContentTitle("The hat working...")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

    @Deprecated("Deprecated in Java")
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate:")
//        setIntentRedelivery(true)
        createChannelForNotification()
        startForeground(NOTIFICATION_ID, notification)
    }


    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(intent: Intent?) {
        (1..100).forEach {
            Thread.sleep(3_000)
            val house = arrayListOf<String>(
                "Griffindor",
                "Slytherin",
                "Ravenclaw",
                "Hufflepuff"
            ).random()
            Log.d(TAG, "Student $it goes to $house !")
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }


    fun createChannelForNotification() {
        val notificationManager =
            application.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel for foreground service"
            val imporance = NotificationManager.IMPORTANCE_DEFAULT
            val channel =
                NotificationChannel(CHANNEL_ID, name, imporance)

            notificationManager.createNotificationChannel(channel)
        }
    }


    companion object {
        private const val SERVICE_NAME = "hat intent service"

        private const val CHANNEL_ID = "foreground service chanel"
        private const val NOTIFICATION_ID = 777
        fun getIntent(context: Context) =
            Intent(context,  HatIntentService::class.java)

    }
}