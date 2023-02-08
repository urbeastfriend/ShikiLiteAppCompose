package com.example.shikiliteappcompose.data.mapper

import com.example.shikiliteappcompose.data.local.WatchListItems.WatchListItemDto
import com.example.shikiliteappcompose.domain.model.WatchListItem
import com.example.shikiliteappcompose.util.EntityMapper
import javax.inject.Inject

class WatchListDomainMapper @Inject constructor() : EntityMapper<WatchListItemDto,WatchListItem>{

    override fun mapFromEntity(entity: WatchListItemDto): WatchListItem {
        return WatchListItem(
            id = entity.id,
            titleName = entity.titleName,
            titleDescription = entity.titleDescription,
            titleStatus = entity.titleStatus,
            watchStatus = entity.watchStatus,
            currentEpisode = entity.currentEpisode,
            totalEpisodes = entity.totalEpisodes,
            thumbPath = entity.thumbPath
        )
    }

    override fun mapFromEntityList(entities: List<WatchListItemDto>): List<WatchListItem> {
        return entities.map { mapFromEntity(it) }
    }
}