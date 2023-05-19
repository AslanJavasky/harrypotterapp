package com.seniorjavasky.harry_potter_and_retrofit.presentation.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.CashCharacterListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.UploadListUseCase
import javax.inject.Inject

class CasherDataWorkerFactory @Inject constructor(
    private val uploadDataUseCase: UploadListUseCase,
    private val cashDataUseCase: CashCharacterListUseCase
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker {
        return CasherDataWorker(
            appContext,
            workerParameters,
            uploadDataUseCase,
            cashDataUseCase
        )
    }


}