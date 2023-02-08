package com.example.shikiliteappcompose.data.local.OnGoingTitles

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface OnGoingListItemsDao {

    @Query("SELECT * FROM onGoingsList_table")
    suspend fun getOnGoingsList() : List<OnGoingListItemDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(onGoingListItem: OnGoingListItemDto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(onGoingListItemList: List<OnGoingListItemDto>)

    @Update
    suspend fun update(onGoingListItem: OnGoingListItemDto)

    @Query("DELETE FROM onGoingsList_table")
    suspend fun clearOnGoingsList()


}