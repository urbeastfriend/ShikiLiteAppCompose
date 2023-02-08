package com.example.shikiliteappcompose.domain.repository

import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.presentation.screens.home.HomeScreenRepositoryResponse
import com.example.shikiliteappcompose.util.RepoCallState
import kotlinx.coroutines.flow.Flow

interface ShikiRepository {

    suspend fun getHomeScreenPageContent(
        fetchFromRemote: Boolean
    ): Flow<RepoCallState<HomeScreenRepositoryResponse>>


}