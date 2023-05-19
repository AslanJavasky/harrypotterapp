package com.seniorjavasky.harry_potter_and_retrofit.lessons.foreground

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.seniorjavasky.harry_potter_and_retrofit.R
import kotlinx.coroutines.*

private const val TAG = "SortingHatForegroundService"

class SortingHatForegroundService : Service() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val notification: Notification
        get() = NotificationCompat.Builder(application, CHANNEL_ID)
            .setSmallIcon(R.drawable.sorting_hat_icon)
            .setContentTitle("The hat working...")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()


    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate:")
        createChannelForNotification()
        startForeground(NOTIFICATION_ID, notification)
    }

    override fun onStartCommand(
        intent: Intent?, flags: Int, startId: Int
    ): Int {

        coroutineScope.launch {
            (1..100).forEach {
                delay(3_000)
                val house = arrayListOf<String>(
                    "Griffindor",
                    "Slytherin",
                    "Ravenclaw",
                    "Hufflepuff"
                ).random()
                Log.d(TAG, "Student $it goes to $house !")
            }
//            stopSelf()
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        coroutineScope.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    fun createChannelForNotification() {
        val notificationManager =
            application.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel for foreground service"
            val imporance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, imporance)

            notificationManager.createNotificationChannel(channel)
        }
    }


    companion object {
        private const val CHANNEL_ID = "foreground service chanel"
        private const val NOTIFICATION_ID = 777
        fun getIntent(context: Context) =
            Intent(context, SortingHatForegroundService::class.java)
    }

}