package com.bangkit.snapeat.di

import com.bangkit.snapeat.data.api.ApiService
import com.bangkit.snapeat.data.repository.FavoriteRepository
import com.bangkit.snapeat.data.repository.UserRepository
import com.bangkit.snapeat.domain.manager.LocalUserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://fuxfkn.i.lokal-so.site/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideFavoriteRepository(apiService: ApiService): FavoriteRepository {
        return FavoriteRepository(apiService)
    }
}
