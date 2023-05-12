package com.seniorjavasky.harry_potter_and_retrofit.lessons

import android.content.Context
import android.util.Log
import androidx.work.*
import com.seniorjavasky.harry_potter_and_retrofit.App
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "WorkManager555"

class HatWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    private val ctx = applicationContext

    override suspend fun doWork(): Result {
        Log.d(TAG, "doWork: ")

        return withContext(Dispatchers.IO) {
            return@withContext try {
                val startIndex = inputData.getInt(KEY_START_STUDENT, 1)
                (startIndex..100).forEach {
                    Thread.sleep(3_000)
                    val house = arrayListOf<String>(
                        "Griffindor",
                        "Slytherin",
                        "Ravenclaw",
                        "Hufflepuff"
                    ).random()
                    Log.d(TAG, "Student $it goes to $house !")
                }
                Result.success(workDataOf(KEY_OUTPUT to "Work done!"))
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
                Result.failure()
            }
        }

    }

    companion object {
        private val workManager = WorkManager.getInstance(App.INSTANCE)

        private fun getInputData(value: Int) =
            Data.Builder()
                .putInt(KEY_START_STUDENT, value)
                .build()

        private fun getRequest(startIndex: Int) = OneTimeWorkRequestBuilder<HatWorker>()
            .setInputData(getInputData(startIndex))
            .build()


        fun start(startIndex: Int = 1) {
            workManager.beginUniqueWork(
                WORK_NAME,
                ExistingWorkPolicy.REPLACE,
                getRequest(startIndex)
            )
                .enqueue()
        }

        fun stop() = workManager.cancelUniqueWork(WORK_NAME)

        const val KEY_START_STUDENT = "key start student"
        const val KEY_OUTPUT = "key output string"
        const val WORK_NAME = "hat sorting work"
    }

}