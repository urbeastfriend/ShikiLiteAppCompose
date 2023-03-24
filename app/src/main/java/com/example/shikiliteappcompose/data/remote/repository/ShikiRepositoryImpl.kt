package com.example.shikiliteappcompose.data.remote.repository

import com.example.shikiliteappcompose.R
import com.example.shikiliteappcompose.data.ShikiDatabase
import com.example.shikiliteappcompose.data.mapper.AnimeToOnGoingMapper
import com.example.shikiliteappcompose.data.mapper.OnGoingDomainMapper
import com.example.shikiliteappcompose.data.mapper.WatchHistoryDomainMapper
import com.example.shikiliteappcompose.data.mapper.WatchListDomainMapper
import com.example.shikiliteappcompose.data.remote.api.ShikiApi
import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.domain.repository.ShikiRepository
import com.example.shikiliteappcompose.presentation.screens.home.HomeScreenRepositoryResponse
import com.example.shikiliteappcompose.util.RepoCallState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShikiRepositoryImpl @Inject constructor(
    private val api: ShikiApi,
    private val db: ShikiDatabase,
    private val animeToOnGoingMapper: AnimeToOnGoingMapper,
    private val onGoingDomainMapper: OnGoingDomainMapper,
    private val watchListDomainMapper: WatchListDomainMapper
) : ShikiRepository {

    private val onGoingsDao = db.onGoingTitlesDao()
    private val watchListDao = db.watchListItemsDao()
    override suspend fun getHomeScreenPageContent(
        fetchFromRemote: Boolean
    ): Flow<RepoCallState<HomeScreenRepositoryResponse>> {

        return flow {
            emit(RepoCallState.Loading(true))

            val localOnGoings = onGoingsDao.getOnGoingsList()
            val watchListItems = watchListDao.getRecentlyWatched()

            emit(
                RepoCallState.Success(
                    data = HomeScreenRepositoryResponse(
                        ongoingsList = onGoingDomainMapper.mapFromEntityList(
                            localOnGoings
                        ),
                        recentlyWatchedList = watchListDomainMapper.mapFromEntityList(
                            watchListItems
                        )
                    )
                )
            )


            val isDbEmpty = localOnGoings.isEmpty()
            val shouldLoadFromCache = !isDbEmpty && !fetchFromRemote

            if (shouldLoadFromCache) {
                emit(RepoCallState.Loading(false))
                return@flow
            }

            val remoteOnGoings = try {
                api.getOngoings()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(
                    RepoCallState.Error(
                        messageId = R.string.api_call_error,
                    )
                )
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(RepoCallState.Error(messageId = R.string.api_call_error))
                null
            }

            remoteOnGoings?.let { onGoings ->
                onGoingsDao.clearOnGoingsList()
                onGoingsDao.insertList(
                    onGoings.map { animeToOnGoingMapper.mapFromEntity(it) }
                )
                emit(
                    RepoCallState.Success(
                        data = HomeScreenRepositoryResponse(
                            ongoingsList = onGoingDomainMapper.mapFromEntityList(
                                onGoingsDao.getOnGoingsList()
                            ),
                            recentlyWatchedList = watchListDomainMapper.mapFromEntityList(
                                watchListItems
                            )
                        )
                    )
                )

            }


            emit(RepoCallState.Loading(false))

        }


    }

}


