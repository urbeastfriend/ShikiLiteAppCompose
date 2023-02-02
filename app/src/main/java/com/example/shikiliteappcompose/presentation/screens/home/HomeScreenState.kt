package com.example.shikiliteappcompose.presentation.screens.home

import com.example.shikiliteappcompose.domain.model.OnGoingListItem

data class HomeScreenState(
    val onGoingsList: List<OnGoingListItem> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessageId: Int? = null

)
