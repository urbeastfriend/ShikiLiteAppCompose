package com.example.shikiliteappcompose.data.local.WatchHistoryItems

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WatchHistoryItemsDao {

    @Query("SELECT * FROM watchhistory_table ORDER BY watchedDateTime LIMIT 10")
    fun getRecentlyWatched() : List<WatchHistoryItemDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(watchHistoryItem: WatchHistoryItemDto)

    @Update
    suspend fun update(watchHistoryItem: WatchHistoryItemDto)

    @Delete
    suspend fun delete(watchHistoryItem: WatchHistoryItemDto)
}