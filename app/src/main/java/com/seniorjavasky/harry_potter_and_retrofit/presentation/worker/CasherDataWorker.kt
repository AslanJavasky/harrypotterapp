package com.seniorjavasky.harry_potter_and_retrofit.presentation.worker

import android.content.Context
import androidx.work.*
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.CashCharacterListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.UploadListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CasherDataWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    val repo = CharacterRepositoryImpl(App.INSTANCE)
    val uploadDataUseCase = UploadListUseCase(repo)
    val cashDataUseCase = CashCharacterListUseCase(repo)


    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {

            return@withContext try {
                cashDataUseCase(
                    uploadDataUseCase()
                )
                Result.success()
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
                Result.failure()
            }
        }
    }

    companion object {

        private val workManager = WorkManager.getInstance(App.INSTANCE)

        private fun getRequest() =
            OneTimeWorkRequestBuilder<CasherDataWorker>()
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
    }
}