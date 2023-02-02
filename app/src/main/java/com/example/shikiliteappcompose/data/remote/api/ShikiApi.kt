package com.example.shikiliteappcompose.data.remote.api

import com.example.shikiliteappcompose.data.remote.ApiEntities.Anime
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ShikiApi {

    @Headers("User-Agent: ShikiLiteApp")
    @GET("/api/animes")
    suspend fun getOngoings(
        @Query("status") status: String = "ongoing"
    ): List<Anime>


    @GET("/api/animes")
    suspend fun getAnimeById(
        @Query("id") id: String
    ): List<Anime>

    @GET("/api/animes")
    suspend fun searchByName(
        @Query("name") name: String,
        @Query("limit") limit: String = SEARCH_LIMIT
    ): List<Anime>


    companion object{
        const val BASE_URL = "https://shikimori.one"
        const val SEARCH_LIMIT = "5"
    }

}

