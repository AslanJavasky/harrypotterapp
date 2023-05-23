package com.seniorjavasky.harry_potter_and_retrofit.lessons.dagger

import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.activities.MainActivity

class Component {

    private fun getTripToHogwarts(): TripToHogwarts {

        val book = Book()
        val owl = Owl()

        return TripToHogwarts(
            freshmanSet = FreshmanSet(
//                MagicWand(CoreOfWand(), WoodOfWand()),
                book,
                owl
            ),
            ticket = Ticket()
        )

    }

    fun inject(mainActivity: MainActivity) {
//        mainActivity.tripToHogwarts = getTripToHogwarts()
    }

}