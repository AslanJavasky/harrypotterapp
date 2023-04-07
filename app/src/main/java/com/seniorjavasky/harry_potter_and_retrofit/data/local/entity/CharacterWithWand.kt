package com.seniorjavasky.harry_potter_and_retrofit.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterWithWand(
    @Embedded
    val characterDb: CharacterDb,
    @Relation(
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val wandDb: WandDb,

    @Relation(
        entity = Book::class,
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val books:List<Book>
)
