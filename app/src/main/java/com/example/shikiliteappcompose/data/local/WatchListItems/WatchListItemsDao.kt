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
    fun getOnGoingsList() : Flow<List<WatchListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(watchListItem: WatchListItem)

    @Update
    suspend fun update(watchListItem: WatchListItem)

    @Delete
    suspend fun delete(watchListItem: WatchListItem)
}