package com.seniorjavasky.harry_potter_and_retrofit.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.Character
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create


const val BASE_URL="https://harry-potter-api-en.onrender.com/characters"

interface SearchCharatersApi{
    @GET
    fun getCharacters():List<Character>

    @GET
    fun getCharacterById(@Query("id") id:Int=1):Character

//    @GET("/{id}")
//    fun getCharacterByIdPath(@Path("id") id:Int=1)
}

object RetrofitInstance{
    private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    val searchCharactersApi:SearchCharatersApi=retrofit.create(SearchCharatersApi::class.java)
}
