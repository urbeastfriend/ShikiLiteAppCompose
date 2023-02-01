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

    @Query("SELECT * FROM watchhistory_table ORDER BY watchedDateTime")
    fun getOnGoingsList() : Flow<List<WatchHistoryItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(watchHistoryItem: WatchHistoryItem)

    @Update
    suspend fun update(watchHistoryItem: WatchHistoryItem)

    @Delete
    suspend fun delete(watchHistoryItem: WatchHistoryItem)
}