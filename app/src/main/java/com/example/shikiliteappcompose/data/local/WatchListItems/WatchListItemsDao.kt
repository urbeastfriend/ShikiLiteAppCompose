package com.example.shikiliteappcompose.data.local.WatchListItems

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WatchListItemsDao {

    @Query("SELECT * FROM watchlist_table ORDER BY titleName")
    fun getWatchedList() : List<WatchListItemDto>

    @Query("SELECT * FROM watchlist_table ORDER BY titleName")
    fun getRecentlyWatched() : List<WatchListItemDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(watchListItem: WatchListItemDto)

    @Update
    suspend fun update(watchListItem: WatchListItemDto)

    @Delete
    suspend fun delete(watchListItem: WatchListItemDto)
}