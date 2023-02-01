package com.example.shikiliteappcompose.util

interface EntityMapper<Entity,DomainModel> {

    fun mapFromEntity(entity: Entity) : DomainModel

    fun mapToEntity(domainModel: DomainModel): Entity

    fun mapFromEntityList(entities: List<Entity>) : List<DomainModel>
}