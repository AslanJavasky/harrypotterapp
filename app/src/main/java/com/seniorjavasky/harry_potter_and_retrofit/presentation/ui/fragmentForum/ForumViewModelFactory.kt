package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentForum

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.data.ForumRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.SendMessageUseCase

class ForumViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ForumViewModel::class.java)){
            return ForumViewModel(SendMessageUseCase(ForumRepositoryImpl(App.INSTANCE))) as T
        }
        throw RuntimeException("Unknown class name")
    }
}