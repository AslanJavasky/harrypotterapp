package com.seniorjavasky.harry_potter_and_retrofit.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "broom")
data class Broom(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "broom_id")
    val broomId:Int,
    @ColumnInfo(name = "name")
    val name:String
)
