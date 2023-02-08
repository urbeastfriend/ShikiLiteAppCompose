package com.example.shikiliteappcompose.data.local.WatchHistoryItems

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.DateFormat

@Parcelize
@Entity(tableName = "watchHistory_table")
class WatchHistoryItemDto(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titleId: String,
    val titleName: String,
    val episodeWatched: String,
    val watchedDateTime: Long = System.currentTimeMillis()
) : Parcelable {
    val watchedDateTimeFormatted: String
        get(){
            return DateFormat.getDateTimeInstance().format(watchedDateTime)
        }
}