package com.example.shikiliteappcompose.data.mapper

import com.example.shikiliteappcompose.data.local.WatchHistoryItems.WatchHistoryItemDto
import com.example.shikiliteappcompose.domain.model.WatchHistoryItem
import com.example.shikiliteappcompose.util.EntityMapper
import javax.inject.Inject

class WatchHistoryDomainMapper @Inject constructor() : EntityMapper<WatchHistoryItemDto,WatchHistoryItem> {
    override fun mapFromEntity(entity: WatchHistoryItemDto): WatchHistoryItem {
        return WatchHistoryItem(id = entity.id,
        titleId = entity.titleId,
        titleName = entity.titleName,
        episodeWatched = entity.episodeWatched,
        watchedDateTime = entity.watchedDateTime)
    }

    override fun mapFromEntityList(entities: List<WatchHistoryItemDto>): List<WatchHistoryItem> {
        return entities.map { mapFromEntity(it) }
    }
}