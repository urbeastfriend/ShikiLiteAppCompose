package com.example.shikiliteappcompose.presentation.screens.home

import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.domain.model.WatchHistoryItem
import com.example.shikiliteappcompose.domain.model.WatchListItem

class HomeScreenRepositoryResponse(
    val ongoingsList: List<OnGoingListItem>,
    val recentlyWatchedList: List<WatchListItem>
)