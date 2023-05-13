package com.seniorjavasky.harry_potter_and_retrofit.data.paging.api



import com.seniorjavasky.harry_potter_and_retrofit.data.paging.dto.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://api.potterdb.com/"

interface SearchCharatersPerPageApi {
    @GET("/v1/characters")
    suspend fun getCharacters(): Response
}

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val searchCharactersApi: SearchCharatersPerPageApi =
        retrofit.create(SearchCharatersPerPageApi::class.java)
}

