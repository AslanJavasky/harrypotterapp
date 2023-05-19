package com.seniorjavasky.harry_potter_and_retrofit.data.firebase

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random


class MessagingUtils(
    private val msgInstance: FirebaseMessaging
) {

    fun logToken(tag:String="FCM token"){
        msgInstance.token.addOnCompleteListener { task ->
            if (task.isSuccessful){
                Log.d(tag, task.result)
                return@addOnCompleteListener
            }
        }
    }

    inner class MyFirebaseMessagingService:FirebaseMessagingService(){

        override fun onMessageReceived(message: RemoteMessage) {
            super.onMessageReceived(message)

            Log.d("aslan555", "onMessageReceived: ${message} ")

            App.INSTANCE.notificationService.showNewNotification(
                notificationIcon = R.drawable.sorting_hat_icon,
                notificationTitle = message.data["message"] ?: "",
                notificationContentText = message.data["message"]+convertToDate(message.data["timestamp"]),
            )
        }

        override fun onNewToken(token: String) {
            super.onNewToken(token)

        }

        private fun convertToDate(timestamp: String?): String {
            timestamp ?: return ""
            return SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                .format(Date(timestamp.toLong() * 1000))
        }
    }

}