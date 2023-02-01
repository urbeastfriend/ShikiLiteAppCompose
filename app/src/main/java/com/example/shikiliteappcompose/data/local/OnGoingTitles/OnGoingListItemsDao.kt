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

    @Query("SELECT * FROM onGoingList_table ORDER BY titleName")
    fun getOnGoingsList() : Flow<List<OnGoingListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(onGoingListItem: OnGoingListItem)

    @Update
    suspend fun update(onGoingListItem: OnGoingListItem)

    @Delete
    suspend fun delete(onGoingListItem: OnGoingListItem)
}