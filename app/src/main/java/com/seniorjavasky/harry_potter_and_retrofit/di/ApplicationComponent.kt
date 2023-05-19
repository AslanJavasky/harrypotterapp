package com.seniorjavasky.harry_potter_and_retrofit.di

import android.app.Application
import android.content.Context
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.data.firebase.FirebaseUtils
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacter.MainFragment
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacter.MainViewModelFactory
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacterList.CharacterListFragment
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacterList.CharacterListViewModelFactory
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentForum.ForumFragment
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentForum.ForumViewModelFactory
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging.PagingFragment
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging.PagingViewModelFactory
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentWorkmanager.WorkmanagerFragment
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentWorkmanager.WorkmanagerViewModelFactory
import com.seniorjavasky.harry_potter_and_retrofit.presentation.worker.CasherDataWorkerFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataModule::class,
//    DomainModule::class,
//    PresentationModule::class,
//    ContextModule::class,
    BindImpls::class,
    FirebaseModule::class
])
interface ApplicationComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application):ApplicationComponent
    }


    fun inject(app:App)
    fun injectMainFragment(mainFragment: MainFragment)
    fun injectCharacterListFragment(characterListFragment: CharacterListFragment)
    fun injectForumFragment(forumFragment: ForumFragment)
    fun injectWorkmanagerFragment(workmanagerFragment: WorkmanagerFragment)
    fun injectPagingFragment(pagingFragment: PagingFragment)

    fun casherDataWorkerFactory(): CasherDataWorkerFactory

}