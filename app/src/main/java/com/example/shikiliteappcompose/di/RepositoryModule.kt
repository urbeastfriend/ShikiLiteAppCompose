package com.example.shikiliteappcompose.di

import com.example.shikiliteappcompose.data.local.OnGoingTitles.OnGoingListItemDto
import com.example.shikiliteappcompose.data.mapper.AnimeToOnGoingMapper
import com.example.shikiliteappcompose.data.mapper.OnGoingDomainMapper
import com.example.shikiliteappcompose.data.remote.ApiEntities.Anime
import com.example.shikiliteappcompose.data.remote.repository.ShikiRepositoryImpl
import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.domain.repository.ShikiRepository
import com.example.shikiliteappcompose.util.EntityMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {




}