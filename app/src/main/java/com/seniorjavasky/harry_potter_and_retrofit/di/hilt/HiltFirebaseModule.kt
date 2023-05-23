package com.seniorjavasky.harry_potter_and_retrofit.di.hilt

import android.app.Application
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.seniorjavasky.harry_potter_and_retrofit.data.ForumRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.data.firebase.AuthUtils
import com.seniorjavasky.harry_potter_and_retrofit.data.firebase.FirebaseUtils
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.ForumRepository
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.SendMessageUseCase
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentForum.ForumViewModel
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentForum.ForumViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HiltFirebaseModule {

    @Provides
    fun provideFirebaseDb(): FirebaseDatabase {
        return Firebase.database
    }

    @Provides
    fun provideFirebaseCrashlytics(): FirebaseCrashlytics {
        return Firebase.crashlytics
    }

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }

    @Provides
    fun provideAuthUI(): AuthUI {
        return AuthUI.getInstance()
    }

    @Provides
    fun provideAuthUtils(
        auth: FirebaseAuth,
        authUI: AuthUI
    ): AuthUtils {
        return AuthUtils(auth, authUI)
    }

    @Provides
    fun provideFirebaseUtils(
        firebaseDatabase: FirebaseDatabase,
        crashlytics: FirebaseCrashlytics,
        authUtils: AuthUtils
    ): FirebaseUtils {
        return FirebaseUtils(firebaseDatabase, crashlytics, authUtils)
    }

    @Provides
    fun provideForumRepositoryImpl(
        application: Application,
        firebaseUtils: FirebaseUtils
    ): ForumRepositoryImpl {
        return ForumRepositoryImpl(application, firebaseUtils)
    }

    @Provides
    fun provideSendMessageUseCase(
        forumRepository: ForumRepository
    ): SendMessageUseCase {
        return SendMessageUseCase(forumRepository)
    }

    @Provides
    fun provideForumViewModel(
        sendMessageUseCase: SendMessageUseCase
    ): ForumViewModel {
        return ForumViewModel(sendMessageUseCase)
    }

    @Provides
    fun provideForumViewModelFactory(
        forumViewModel: ForumViewModel
    ): ForumViewModelFactory {
        return ForumViewModelFactory(forumViewModel)
    }




}