package com.example.shikiliteappcompose.data.local.OnGoingTitles

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "onGoingList_table")
class OnGoingListItem(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val titleName: String,
    val titleStudio: String,
    val thumbPath: String
) :Parcelable