package com.example.shikiliteappcompose.data.mapper

import com.example.shikiliteappcompose.data.local.OnGoingTitles.OnGoingListItemDto
import com.example.shikiliteappcompose.data.remote.ApiEntities.Anime
import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.util.EntityMapper
import javax.inject.Inject
import javax.inject.Singleton


class OnGoingDomainMapper @Inject constructor() : EntityMapper<OnGoingListItemDto, OnGoingListItem> {

    override fun mapFromEntity(entity: OnGoingListItemDto): OnGoingListItem {
        return(OnGoingListItem(
            id = entity.id,
            titleName = entity.titleName,
            thumbPath = entity.thumbPath
        ))
    }

    override fun mapFromEntityList(entities: List<OnGoingListItemDto>): List<OnGoingListItem> {
        return entities.map { mapFromEntity(it) }
    }
}