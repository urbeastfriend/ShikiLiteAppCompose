package com.example.shikiliteappcompose.presentation.screens.home

import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.domain.model.WatchHistoryItem
import com.example.shikiliteappcompose.domain.model.WatchListItem

data class HomeScreenState(
    val onGoingsList: List<OnGoingListItem> = emptyList(),
    val recentlyWatchedList: List<WatchListItem> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val errorMessageId: Int? = null
)
