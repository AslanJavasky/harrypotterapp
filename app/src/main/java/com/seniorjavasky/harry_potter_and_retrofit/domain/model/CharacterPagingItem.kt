package com.seniorjavasky.harry_potter_and_retrofit.domain.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class CharacterPagingItem(
    val id:String,
    val name:String?,
    val bloodStatus:String?=null,
    val hogwartsHouse:String?=null,
    val patronus:String?=null,
    val imageUrl:String?=null
)