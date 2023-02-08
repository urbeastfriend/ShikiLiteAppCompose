package com.example.shikiliteappcompose.data.mapper

import com.example.shikiliteappcompose.data.local.OnGoingTitles.OnGoingListItemDto
import com.example.shikiliteappcompose.data.remote.ApiEntities.Anime
import com.example.shikiliteappcompose.data.remote.api.ShikiApi
import com.example.shikiliteappcompose.util.EntityMapper
import javax.inject.Inject
import javax.inject.Singleton


class AnimeToOnGoingMapper @Inject constructor() : EntityMapper<Anime,OnGoingListItemDto> {

    override fun mapFromEntity(entity: Anime): OnGoingListItemDto {
        return OnGoingListItemDto(
            id = entity.id,
            titleName = entity.name,
            thumbPath = ShikiApi.BASE_URL+entity.image.preview

        )
    }


    override fun mapFromEntityList(entities: List<Anime>): List<OnGoingListItemDto> {
        return entities.map { mapFromEntity(it) }
    }
}