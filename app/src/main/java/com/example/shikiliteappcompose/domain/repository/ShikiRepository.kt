package com.example.shikiliteappcompose.domain.repository

import com.example.shikiliteappcompose.data.local.OnGoingTitles.OnGoingListItemDto
import com.example.shikiliteappcompose.data.local.WatchListItems.WatchListItem
import com.example.shikiliteappcompose.data.remote.ApiEntities.Anime
import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.util.RepoCallState
import kotlinx.coroutines.flow.Flow

interface ShikiRepository {

    suspend fun getOnGoings(
    ): Flow<RepoCallState<List<OnGoingListItem>>>

    suspend fun searchByName(
        name: String
    ): Flow<List<Anime>>

    suspend fun getAnimeById(
        id: String
    ): Flow<List<Anime>>

    suspend fun getRecentlyViewed(): Flow<List<WatchListItem>>
}