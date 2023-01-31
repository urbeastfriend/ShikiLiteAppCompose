package com.example.shikiliteappcompose.di

import com.example.shikiliteappcompose.data.remote.api.ShikiApi
import com.example.shikiliteappcompose.data.remote.repository.ShikiRepositoryImpl
import com.example.shikiliteappcompose.domain.repository.ShikiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideShikiApi(): ShikiApi {
        return Retrofit.Builder()
            .baseUrl(ShikiApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ShikiApi::class.java)
    }

    @Provides
    @Singleton
    fun provideShikiRepository(api: ShikiApi): ShikiRepository {
        return ShikiRepositoryImpl(api)
    }

}