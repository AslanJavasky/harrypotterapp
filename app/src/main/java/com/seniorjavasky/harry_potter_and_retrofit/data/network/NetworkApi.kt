package com.seniorjavasky.harry_potter_and_retrofit.data.network

import com.seniorjavasky.harry_potter_and_retrofit.data.network.dto.CharacterDto
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.Duration
import java.util.concurrent.TimeUnit


const val BASE_URL = "https://harry-potter-api-en.onrender.com"
interface SearchCharatersApi {
    @GET("/characters")
    suspend fun getCharacters(): List<CharacterDto>

    @GET("/characters/{id}")
    suspend fun getCharacterById(@Path("id") id:Int=1): CharacterDto

//    @GET("/characters")
//    suspend fun getCharacterById_Param(@Query("id") id: Int = 1): CharacterDto
}

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val searchCharactersApi: SearchCharatersApi =
        retrofit.create(SearchCharatersApi::class.java)
}
