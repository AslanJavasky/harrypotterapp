package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class PagingViewModelFactory @Inject constructor(
    private val pagingViewModel: PagingViewModel
):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PagingViewModel::class.java)){
            return pagingViewModel as T
        }
        throw IllegalArgumentException("Unknown class name: $modelClass")
    }
}