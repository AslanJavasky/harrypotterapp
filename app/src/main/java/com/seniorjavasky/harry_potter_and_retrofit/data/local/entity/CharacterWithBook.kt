package com.seniorjavasky.harry_potter_and_retrofit.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterWithBook(
    @Embedded
    val characterDb: CharacterDb,
    @Relation(
        entity = Book::class,
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val book: List<Book>

)