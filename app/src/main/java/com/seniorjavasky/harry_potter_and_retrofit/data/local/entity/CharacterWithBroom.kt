package com.seniorjavasky.harry_potter_and_retrofit.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity
data class CharacterWithBroom(

    @Embedded
    val characterDb: CharacterDb,
    @Relation(
        parentColumn = "id",
        entityColumn = "broom_id",
        associateBy =Junction(
            CharacterBroom::class,//Связующая таблица
            parentColumn = "character_id",
            entityColumn = "broom_id"
        )

    )
    val broom: List<Broom>
)
