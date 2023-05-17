package com.seniorjavasky.harry_potter_and_retrofit.data.paging.api


import com.seniorjavasky.harry_potter_and_retrofit.data.paging.dto.Response
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://api.potterdb.com/"

interface SearchCharatersPerPageApi {
    @GET("/v1/characters")
    suspend fun getCharacters(@Query("page[number]") page: Int = 1): Response
}

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .client(
            OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            }).build()
        )
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val searchCharactersApi: SearchCharatersPerPageApi =
        retrofit.create(SearchCharatersPerPageApi::class.java)
}

