package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentWorkmanager

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.CashCharacterListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.UploadListUseCase
import com.seniorjavasky.harry_potter_and_retrofit.presentation.worker.CasherDataWorker
import javax.inject.Inject

class WorkmanagerViewModel @Inject constructor(
    val context: Application
) : ViewModel() {

    internal val progressWorkInfoItems: LiveData<List<WorkInfo>>

    init {
        progressWorkInfoItems=
            CasherDataWorker.getWorkManager()
                .getWorkInfosByTagLiveData(CasherDataWorker.TAG_PROGRESS)
        CasherDataWorker.start()
    }

    fun startService() {
        CasherDataWorker.start()
    }

    fun stopService() {
        CasherDataWorker.stop()
    }

}