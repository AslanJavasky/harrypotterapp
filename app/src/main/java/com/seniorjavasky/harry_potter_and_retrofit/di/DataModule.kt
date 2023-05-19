package com.seniorjavasky.harry_potter_and_retrofit.di

import android.app.Application
import com.seniorjavasky.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.data.local.dao.CharacterDao
import com.seniorjavasky.harry_potter_and_retrofit.data.local.database.CharacterDatabase
import com.seniorjavasky.harry_potter_and_retrofit.data.mappers.CharacterMapper
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.mapper.CharacterPagingMapper
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.pagingSource.CharacterPagingSource
import com.seniorjavasky.harry_potter_and_retrofit.data.paging.repoImpl.CharacterPagingRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {

//    @Provides
//    fun provideMapperForCharacterRepositoryImpl(): CharacterMapper{
//        return CharacterMapper()
//    }

    @Provides
    fun provideCharacterDao(application: Application):CharacterDao{
        return CharacterDatabase.getInstance(application).characterDao()
    }

//    @Provides
//    fun provideCharacterPagingMapper():CharacterPagingMapper{
//        return CharacterPagingMapper()
//    }
//
//    @Provides
//    fun provideCharacterPagingSource(
//        characterPagingMapper: CharacterPagingMapper
//    ): CharacterPagingSource {
//        return CharacterPagingSource(characterPagingMapper)
//    }

//    @Provides
//    fun provideCharacterPagingRepositoryImpl(
//        characterPagingSource: CharacterPagingSource
//    ): CharacterPagingRepositoryImpl{
//        return CharacterPagingRepositoryImpl(characterPagingSource)
//    }

//    @Provides
//    fun provideCharacterRepositoryImpl(
//        application: Application,
//        characterMapper: CharacterMapper,
//        characterDao: CharacterDao
//    ): CharacterRepositoryImpl {
//        return CharacterRepositoryImpl(application, characterMapper,characterDao)
//    }


}