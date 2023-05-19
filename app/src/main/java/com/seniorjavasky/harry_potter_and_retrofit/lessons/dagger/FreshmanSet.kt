package com.seniorjavasky.harry_potter_and_retrofit.lessons.dagger

import javax.inject.Inject

class FreshmanSet @Inject constructor(
    magicWand: MagicWand,
    book: Book,
    owl: Owl
)