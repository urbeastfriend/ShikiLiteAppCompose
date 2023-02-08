package com.example.shikiliteappcompose.domain.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import java.text.DateFormat

data class WatchHistoryItem(
    val id: Int,
    val titleId: String,
    val titleName: String,
    val episodeWatched: String,
    val watchedDateTime: Long = System.currentTimeMillis()
) {
    val watchedDateTimeFormatted: String
        get() {
            return DateFormat.getDateTimeInstance().format(watchedDateTime)
        }
}