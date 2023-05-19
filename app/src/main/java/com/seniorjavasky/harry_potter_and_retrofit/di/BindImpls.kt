package com.seniorjavasky.harry_potter_and_retrofit.di

import com.seniorjavasky.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.data.ForumRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.repoImpl.CharacterPagingRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterPagingRepository
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.ForumRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface BindImpls {

    @Binds
    fun bindCharaterRepo(
        characterRepositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository

    @Binds
    fun bindForumRepository(
        forumRepositoryImpl: ForumRepositoryImpl
    ): ForumRepository

    @Binds
    fun bindCharacterPagingRepository(
        characterPagingRepositoryImpl: CharacterPagingRepositoryImpl
    ): CharacterPagingRepository
}

