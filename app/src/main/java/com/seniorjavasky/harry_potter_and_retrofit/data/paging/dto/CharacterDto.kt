package com.seniorjavasky.harry_potter_and_retrofit.data.paging.dto

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//Dto for Moshi

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name="data")
    val data:List<DataJson>
)

@JsonClass(generateAdapter = true)
data class DataJson(
    val id:String,
    @Json(name="attributes")
    val attributes:Attributes
)
@JsonClass(generateAdapter = true)
data class Attributes(
    @Json(name="name")
    val name:String?,
    @Json(name="blood_status")
    val bloodStatus:String?,
    @Json(name="house")
    val hogwartsHouse:String?,
    @Json(name="patronus")
    val patronus:String?,
    @Json(name="image")
    val imageUrl:String?
)



//Dto for Gson
//data class CharacterDto(
//    @SerializedName("id")
//    val id:Int,
//    @SerializedName("character")
//    val name:String,
//    @SerializedName("hogwartsHouse")
//    val hogwartsHouse:String,
//    @SerializedName("image")
//    val imageUrl:String
//)