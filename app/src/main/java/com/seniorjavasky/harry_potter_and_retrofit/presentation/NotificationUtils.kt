package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.R

class NotificationUtils(
    private val application: Application
) {


    fun createNotificationChannel() {
        if (checkBuildVersionMoreThenOrEquealO()){
            val name = "Our Notification Channel"
            val imporance = NotificationManager.IMPORTANCE_HIGH
            val descriptionText = "Some description text"
            val channel = NotificationChannel(CHANNEL_ID, name, imporance).apply {
                description = descriptionText
            }

            val notificationManager =
                application.getSystemService(
                    Context.NOTIFICATION_SERVICE
                ) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


    fun createNotification() {

        val intent = Intent(application, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            application, 0, intent, getCorrectFlagForPendingIntent()
        )

        val notification = NotificationCompat.Builder(application, CHANNEL_ID)
            .setSmallIcon(R.drawable.small_icon_for_notification)
            .setContentTitle("Our test notification")
            .setContentText("Some description of our test notification")
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val isGrantedNotification= (application as App).permissionService.isPostNotificationsGranted()
        if (isGrantedNotification !=null) {
            if (isGrantedNotification){
                showNotification(notification)
            }
        } else{
            showNotification(notification)
        }
    }

    @SuppressLint("MissingPermission")
    private fun showNotification(notification: Notification) {
        NotificationManagerCompat.from(application).notify(
            NOTIFICATION_ID, notification
        )
    }

    private fun checkBuildVersionMoreThenOrEquealO()=
       Build.VERSION.SDK_INT >= Build.VERSION_CODES.O

    private fun getCorrectFlagForPendingIntent() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.FLAG_IMMUTABLE
        } else {
            PendingIntent.FLAG_UPDATE_CURRENT
        }


    companion object {
        private const val CHANNEL_ID = "channel_id"
        private const val NOTIFICATION_ID = 555
        private var INSTANCE:NotificationUtils?=null
        private var LOCK=Any()

        fun getInstance(application: Application): NotificationUtils {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }

                INSTANCE = NotificationUtils(application)
                return NotificationUtils(application)
            }
        }
    }

}