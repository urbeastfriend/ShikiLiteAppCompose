package com.example.shikiliteappcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.shikiliteappcompose.data.local.OnGoingTitles.OnGoingListItem
import com.example.shikiliteappcompose.data.local.OnGoingTitles.OnGoingListItemsDao
import com.example.shikiliteappcompose.data.local.WatchHistoryItems.WatchHistoryItem
import com.example.shikiliteappcompose.data.local.WatchHistoryItems.WatchHistoryItemsDao
import com.example.shikiliteappcompose.data.local.WatchListItems.WatchListItem
import com.example.shikiliteappcompose.data.local.WatchListItems.WatchListItemsDao
import com.example.shikiliteappcompose.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [WatchListItem::class,WatchHistoryItem::class,OnGoingListItem::class], version = 1, exportSchema = false)
abstract class ShikiDatabase: RoomDatabase() {

    abstract fun onGoingTitlesDao(): OnGoingListItemsDao

    abstract fun watchHistoryItemsDao(): WatchHistoryItemsDao

    abstract fun watchListItemsDao(): WatchListItemsDao

    class CallBack @Inject constructor(
        private val database: Provider<ShikiDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val onGoingTitlesDao = database.get().onGoingTitlesDao()

            applicationScope.launch {
                onGoingTitlesDao.insert(OnGoingListItem(titleName = "Атака титанов",
                    titleStudio = "Wit studio",
                    id = 1,
                    thumbPath = "https://desu.shikimori.one/uploads/poster/animes/16498/d48cf869a01f48bfe18b96b7978e417c.jpeg"))

                onGoingTitlesDao.insert(OnGoingListItem(titleName = "Атака титанов 2",
                    titleStudio = "Wit studio",
                    id = 2,
                    thumbPath = "https://moe.shikimori.one/uploads/poster/animes/25777/fceb2e2a48193fb6e220777d09c70693.jpeg"))

                onGoingTitlesDao.insert(OnGoingListItem(titleName = "Атака титанов 3",
                    titleStudio = "Wit studio",
                    id = 3,
                    thumbPath = "https://nyaa.shikimori.one/uploads/poster/animes/35760/cdb107859ca0412d8a492903d7a5a8ba.jpeg"))

                onGoingTitlesDao.insert(OnGoingListItem(titleName = "Атака титанов 3. Часть 2",
                    titleStudio = "Wit studio",
                    id = 3,
                    thumbPath = "https://dere.shikimori.one/uploads/poster/animes/38524/36710503ef03f4347ef82ae8bd263cb3.jpeg"))
            }
        }
    }
}