package com.seniorjavasky.harry_potter_and_retrofit.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

//Связующие таблицы
@Entity(
    tableName = "character_broom",
    primaryKeys = ["character_id", "broom_id"])

data class CharacterBroom(
    @ColumnInfo(name = "character_id")
    val characterId: Int,
    @ColumnInfo(name = "broom_id")
    val broomId: Int,
)
