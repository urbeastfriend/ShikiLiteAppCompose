package com.example.shikiliteappcompose.di

import android.app.Application
import androidx.room.Room
import com.example.shikiliteappcompose.data.ShikiDatabase
import com.example.shikiliteappcompose.data.local.OnGoingTitles.OnGoingListItemDto
import com.example.shikiliteappcompose.data.mapper.AnimeToOnGoingMapper
import com.example.shikiliteappcompose.data.mapper.OnGoingDomainMapper
import com.example.shikiliteappcompose.data.remote.ApiEntities.Anime
import com.example.shikiliteappcompose.data.remote.api.ShikiApi
import com.example.shikiliteappcompose.data.remote.repository.ShikiRepositoryImpl
import com.example.shikiliteappcompose.domain.model.OnGoingListItem
import com.example.shikiliteappcompose.domain.repository.ShikiRepository
import com.example.shikiliteappcompose.util.EntityMapper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideAnimeToOnGoingMapper(
        animeToOnGoingMapper: AnimeToOnGoingMapper
    ): EntityMapper<Anime,OnGoingListItemDto>  = animeToOnGoingMapper

    @Provides
    fun provideOnGoingDomainMapper(
        onGoingDomainMapper: OnGoingDomainMapper
    ): EntityMapper<OnGoingListItemDto,OnGoingListItem> = onGoingDomainMapper

    @Provides
    fun provideRepository(
        shikiRepositoryImpl: ShikiRepositoryImpl
    ): ShikiRepository  = shikiRepositoryImpl

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            })
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(3, TimeUnit.SECONDS)
            .writeTimeout(3, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideDataBase(app: Application, callback: ShikiDatabase.CallBack): ShikiDatabase {
        return Room.databaseBuilder(app, ShikiDatabase::class.java, "shikidb.db")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }


    @Provides
    @Singleton
    fun provideShikiApi(gson: Gson, okHttpClient: OkHttpClient): ShikiApi {
        return Retrofit.Builder().baseUrl(ShikiApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShikiApi::class.java)
    }

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope