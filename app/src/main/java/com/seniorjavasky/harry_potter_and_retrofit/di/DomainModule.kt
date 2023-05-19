package com.seniorjavasky.harry_potter_and_retrofit.di

import android.app.Application
import com.seniorjavasky.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import com.seniorjavasky.harry_potter_and_retrofit.data.local.dao.CharacterDao
import com.seniorjavasky.harry_potter_and_retrofit.data.mappers.CharacterMapper
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterPagingRepository
import com.seniorjavasky.harry_potter_and_retrofit.domain.repository.CharacterRepository
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
//
//    @Provides
//    fun provideGetCharacterListUseCase(
//        characterRepository: CharacterRepository
//    ): GetCharacterListUseCase {
//        return GetCharacterListUseCase(characterRepository)
//    }

//    @Provides
//    fun provideGetCharacterUseCase(
//        characterRepository: CharacterRepository
//    ): GetCharacterUseCase {
//        return GetCharacterUseCase(characterRepository)
//    }


//    @Provides
//    fun provideUploadListUseCase(
//        characterRepository: CharacterRepository
//    ): UploadListUseCase {
//        return UploadListUseCase(characterRepository)
//    }

//    @Provides
//    fun provideCashCharacterListUseCase(
//        characterRepository: CharacterRepository
//    ): CashCharacterListUseCase {
//        return CashCharacterListUseCase(characterRepository)
//    }

//    @Provides
//    fun provideGetPagerForCharactersUseCase(
//        characterPagingRepository: CharacterPagingRepository
//    ): GetPagerForCharactersUseCase{
//        return GetPagerForCharactersUseCase(characterPagingRepository)
//    }
}