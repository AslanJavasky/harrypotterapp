package com.seniorjavasky.harry_potter_and_retrofit.lessons.dagger

import javax.inject.Inject

class TripToHogwarts @Inject constructor(
    freshmanSet:FreshmanSet,
    ticket:Ticket
)