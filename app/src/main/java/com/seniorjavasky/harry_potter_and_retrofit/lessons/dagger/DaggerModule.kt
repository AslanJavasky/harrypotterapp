package com.seniorjavasky.harry_potter_and_retrofit.lessons.dagger

import dagger.Module
import dagger.Provides

@Module
class DaggerModule {

    @Provides
    fun provideTicket() = Ticket()
}