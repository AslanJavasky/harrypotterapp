package com.seniorjavasky.harry_potter_and_retrofit.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wand")
data class WandDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    val id:Int,
    @ColumnInfo(name = "character_id")
    val characterId:Int,
    @ColumnInfo(name = "core")
    val core: String,
    @ColumnInfo(name = "length")
    val length: Int
)