package com.example.shikiliteappcompose.data.local.WatchListItems

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "watchList_table")
class WatchListItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val titleName: String,
    val titleDescription: String,
    val titleStatus: String = "released",
    val watchStatus: String = "Watching",
    val currentEpisode: String = "0",
    val totalEpisodes: String = "?",
    val thumbPath: String
) : Parcelable