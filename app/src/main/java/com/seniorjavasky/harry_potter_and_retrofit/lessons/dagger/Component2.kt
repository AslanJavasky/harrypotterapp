package com.seniorjavasky.harry_potter_and_retrofit.lessons.dagger

import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.activities.MainActivity
import dagger.Component

//@Component(modules = [DaggerModule::class])
interface Component2 {

//    fun getTripToHogwarts(): TripToHogwarts

    fun inject(mainActivity: MainActivity)
}