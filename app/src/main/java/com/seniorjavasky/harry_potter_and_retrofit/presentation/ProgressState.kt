package com.seniorjavasky.harry_potter_and_retrofit.presentation

sealed class ProgressState{
    object Loading:ProgressState()
    object Success:ProgressState()
}
