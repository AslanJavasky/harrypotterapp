package com.seniorjavasky.harry_potter_and_retrofit.di

import android.app.Application
import com.seniorjavasky.harry_potter_and_retrofit.domain.usecase.*
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacter.MainViewModel
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacter.MainViewModelFactory
import dagger.Module
import dagger.Provides
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacterList.CharacterListViewModel
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacterList.CharacterListViewModelFactory
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging.PagingViewModel
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging.PagingViewModelFactory
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentWorkmanager.WorkmanagerViewModel
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentWorkmanager.WorkmanagerViewModelFactory
import com.seniorjavasky.harry_potter_and_retrofit.presentation.worker.CasherDataWorkerFactory

@Module
class PresentationModule {


//    @Provides
//    fun provideMainViewModel(
//        characterUseCase: GetCharacterUseCase
//    ): MainViewModel {
//        return MainViewModel(
//            characterUseCase
//        )
//    }

//    @Provides
//    fun provideCharacterListViewModel(
//        characterListUseCase: GetCharacterListUseCase
//    ): CharacterListViewModel {
//        return CharacterListViewModel(
//            characterListUseCase
//        )
//    }


//    @Provides
//    fun provideCharacterListViewModelFactory(
//        characterListViewModel: CharacterListViewModel
//    ): CharacterListViewModelFactory {
//        return CharacterListViewModelFactory(characterListViewModel)
//    }


//    @Provides
//    fun provideMainViewModelFactory(
//        mainViewModel: MainViewModel
//    ): MainViewModelFactory {
//        return MainViewModelFactory(mainViewModel)
//    }

//    @Provides
//    fun provideWorkmanagerViewModel(
//        application: Application,
//    ): WorkmanagerViewModel {
//        return WorkmanagerViewModel(application)
//    }

//    @Provides
//    fun provideWorkmanagerViewModelFactory(
//        workmanagerViewModel: WorkmanagerViewModel
//    ): WorkmanagerViewModelFactory {
//        return WorkmanagerViewModelFactory(workmanagerViewModel)
//    }


//    @Provides
//    fun provideCasherDataWorkerFactory(
//        uploadDataUseCase: UploadListUseCase,
//        cashDataUseCase: CashCharacterListUseCase
//    ): CasherDataWorkerFactory {
//        return CasherDataWorkerFactory(uploadDataUseCase, cashDataUseCase)
//    }

//    @Provides
//    fun providePagingViewModel(
//        getPagerForCharactersUseCase: GetPagerForCharactersUseCase
//    ): PagingViewModel {
//        return PagingViewModel(getPagerForCharactersUseCase)
//    }

//    @Provides
//    fun providPagingViewModelFactory(
//        pagingViewModel: PagingViewModel
//    ): PagingViewModelFactory {
//        return PagingViewModelFactory(pagingViewModel)
//    }

}