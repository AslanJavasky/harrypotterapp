package com.seniorjavasky.harry_potter_and_retrofit.lessons

import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Context
import android.util.Log
import kotlinx.coroutines.*

private const val TAG = "MyJobService"

class MyJobService : JobService() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }

    override fun onStartJob(params: JobParameters?): Boolean {
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
            jobFinished(params, true)
        }
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d(TAG, "onStopJob: ")
        return true
    }


    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
        Log.d(TAG, "onDestroy: ")
    }

    companion object{
        const val JOB_ID=777
        fun getJobService()=MyJobService::class.java
    }
}

//fun startService() {
//
//    val jobService= ComponentName(context,MyJobService.getJobService())
//    val job= JobInfo.Builder(MyJobService.JOB_ID,jobService)
//        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
//        .setPersisted(true)
//        .setRequiresCharging(true)
//        .build()
//
//
//    val jobScheduler=context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
//    jobScheduler.schedule(job)
//}