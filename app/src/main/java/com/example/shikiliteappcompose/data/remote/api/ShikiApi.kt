package com.example.shikiliteappcompose.data.remote.api

import com.example.shikiliteappcompose.data.remote.ApiEntities.Anime
import retrofit2.http.GET

interface ShikiApi {

    @GET("/api/animes")
    suspend fun getAnimes(): List<Anime>


    companion object{
        const val BASE_URL = "shikimori.one"
    }
}

