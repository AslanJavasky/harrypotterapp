package com.seniorjavasky.harry_potter_and_retrofit.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(
    private val application: Application
    ) {
//
//    @Provides
//    fun provideContext(): Application {
//        return application
//    }
}