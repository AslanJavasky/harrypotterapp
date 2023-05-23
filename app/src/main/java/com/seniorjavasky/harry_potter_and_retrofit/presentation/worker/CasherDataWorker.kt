package com.seniorjavasky.harry_potter_and_retrofit.presentation.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.CashCharacterListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.UploadListUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@HiltWorker
class CasherDataWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val uploadDataUseCase: UploadListUseCase,
    private val cashDataUseCase: CashCharacterListUseCase
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        makeNotification("Start")
        (0..100 step 10).forEach {
            delay(300)
            setProgress(workDataOf(PROGRESS to it))
        }

        return withContext(Dispatchers.IO) {

            return@withContext try {
                cashDataUseCase(
                    uploadDataUseCase()
                )
                makeNotification("Finish")
                Result.success()

            } catch (throwable: Throwable) {
                throwable.printStackTrace()
                makeNotification("Error")
                Result.failure()
            }

        }
    }

    private fun makeNotification(notContent: String) {
        App.INSTANCE.notificationService.showNewNotification(
            notificationIcon = R.drawable.sorting_hat_icon,
            notificationContentText = notContent,
            notificationTitle = "Cashing"
        )
    }

    companion object {

        private val workManager = WorkManager.getInstance(App.INSTANCE)

        fun getWorkManager() = workManager

        private fun getRequest() =
            OneTimeWorkRequestBuilder<CasherDataWorker>()
                .addTag(TAG_PROGRESS)
                .build()


        fun start() {
            workManager.beginUniqueWork(
                WORK_NAME,
                ExistingWorkPolicy.REPLACE,
                getRequest()
            )
                .enqueue()

        }

        fun stop() = workManager.cancelUniqueWork(WORK_NAME)

        private const val WORK_NAME = "cashing data into room db work"
        const val PROGRESS = "progress"
        const val TAG_PROGRESS = "=tag_progress"
    }
}