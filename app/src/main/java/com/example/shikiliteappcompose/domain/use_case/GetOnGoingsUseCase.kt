package com.example.shikiliteappcompose.domain.use_case

import android.util.Log
import com.example.shikiliteappcompose.data.ShikiDatabase
import com.example.shikiliteappcompose.data.local.OnGoingTitles.OnGoingListItemsDao
import com.example.shikiliteappcompose.data.mapper.AnimeToOnGoingMapper
import com.example.shikiliteappcompose.data.mapper.OnGoingDomainMapper
import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.domain.repository.ShikiRepository
import com.example.shikiliteappcompose.util.RepoCallState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetOnGoingsUseCase @Inject constructor(
    private val repository: ShikiRepository,
    private val db: ShikiDatabase,
    private val animeToOnGoingMapper: AnimeToOnGoingMapper,
    private val onGoingDomainMapper: OnGoingDomainMapper
) {
    operator fun invoke(): Flow<RepoCallState<List<OnGoingListItem>>> = flow {
        val onGoings = db.onGoingTitlesDao().getOnGoingsList()
        Log.d("urls", "ongoings lenght before mapping ${onGoings.size}")
        emit(RepoCallState.Success(onGoingDomainMapper.mapFromEntityList(onGoings)))
    }
}