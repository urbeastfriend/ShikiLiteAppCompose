package com.example.shikiliteappcompose.domain.model

import androidx.room.PrimaryKey

data class WatchListItem(
    val id: Int,
    val titleName: String,
    val titleDescription: String,
    val titleStatus: String = "released",
    val watchStatus: String = "Watching",
    val currentEpisode: String = "0",
    val totalEpisodes: String = "?",
    val thumbPath: String
)