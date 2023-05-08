package com.seniorjavasky.harry_potter_and_retrofit.lessons

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*


private const val TAG = "SortingHat"

class MyService : Service() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate:")

    }

    override fun onStartCommand(
        intent: Intent?, flags: Int, startId: Int): Int {

        val indexForItearating=intent?.getIntExtra(KEY_EXTRA,1) ?: 1

        coroutineScope.launch {
            (indexForItearating..100).forEach {
                delay(3_000)
                val house = arrayListOf<String>(
                    "Griffindor",
                    "Slytherin",
                    "Ravenclaw",
                    "Hufflepuff"
                ).random()
                Log.d(TAG, "Student $it goes to $house !")
            }
        }
        return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        coroutineScope.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    companion object {
        private const val KEY_EXTRA="index"

        fun getIntent(context: Context, index:Int) =
            Intent(context, MyService::class.java).apply {
                putExtra(KEY_EXTRA, index)
            }
    }

}