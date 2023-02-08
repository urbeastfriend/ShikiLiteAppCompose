package com.example.shikiliteappcompose.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

class OnGoingListItem(
    val id: Int,
    val titleName: String,
    val thumbPath: String
)