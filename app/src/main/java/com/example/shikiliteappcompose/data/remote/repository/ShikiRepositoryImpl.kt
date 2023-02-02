package com.example.shikiliteappcompose.data.remote.repository

import com.example.shikiliteappcompose.R
import com.example.shikiliteappcompose.data.ShikiDatabase
import com.example.shikiliteappcompose.data.local.OnGoingTitles.OnGoingListItemDto
import com.example.shikiliteappcompose.data.local.WatchListItems.WatchListItem
import com.example.shikiliteappcompose.data.mapper.AnimeToOnGoingMapper
import com.example.shikiliteappcompose.data.mapper.OnGoingDomainMapper
import com.example.shikiliteappcompose.data.remote.ApiEntities.Anime
import com.example.shikiliteappcompose.data.remote.api.ShikiApi
import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.domain.repository.ShikiRepository
import com.example.shikiliteappcompose.util.RepoCallState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShikiRepositoryImpl @Inject constructor(
    private val api: ShikiApi,
    private val db: ShikiDatabase,
    private val animeToOnGoingMapper: AnimeToOnGoingMapper,
    private val onGoingDomainMapper: OnGoingDomainMapper
) : ShikiRepository {

    private val onGoingsDao = db.onGoingTitlesDao()
    override suspend fun getOnGoings(): Flow<RepoCallState<List<OnGoingListItem>>> {

        return flow {

            val localOnGoings = onGoingsDao.getOnGoingsList()
            emit(RepoCallState.Success(data = onGoingDomainMapper.mapFromEntityList(localOnGoings)))

            val remoteOnGoings = try {
                api.getOngoings()
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(
                    RepoCallState.Error(
                        messageId = R.string.api_call_error,
                        data = onGoingDomainMapper.mapFromEntityList(localOnGoings)
                    )
                )
                null

            }
            catch (e: IOException) {
                e.printStackTrace()
                emit(
                    RepoCallState.Error(
                        messageId = R.string.api_call_error,
                        data = onGoingDomainMapper.mapFromEntityList(localOnGoings)
                    )
                )
                null
            }

            remoteOnGoings?.let { onGoings ->
                onGoingsDao.clearOnGoingsList()
                onGoingsDao.insertList(
                    onGoings.map { animeToOnGoingMapper.mapFromEntity(it) }
                )
                emit(RepoCallState.Success(
                        data = onGoingDomainMapper.mapFromEntityList(onGoingsDao.getOnGoingsList())
                    )
                )

            }


            emit(RepoCallState.Loading(false))

        }


    }

    override suspend fun searchByName(name: String): Flow<List<Anime>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAnimeById(id: String): Flow<List<Anime>> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecentlyViewed(): Flow<List<WatchListItem>> {
        TODO("Not yet implemented")
    }
}


