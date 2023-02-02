package com.example.shikiliteappcompose.domain.use_case

import com.example.shikiliteappcompose.data.local.OnGoingTitles.OnGoingListItemsDao
import com.example.shikiliteappcompose.data.mapper.OnGoingDomainMapper
import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.domain.repository.ShikiRepository
import com.example.shikiliteappcompose.util.RepoCallState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetOnGoingsUseCase @Inject constructor(
    private val repository: ShikiRepository,
) {
    operator fun invoke(): Flow<RepoCallState<List<OnGoingListItem>>> = flow {
        repository.getOnGoings()
    }
}