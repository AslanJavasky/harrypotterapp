package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacter

sealed class ProgressState{
    object Loading: ProgressState()
    object Success: ProgressState()
}
