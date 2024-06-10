package com.bangkit.snapeat.di

import android.app.Application
import com.bangkit.snapeat.data.manager.LocalUserManagerImplementation
import com.bangkit.snapeat.domain.manager.LocalUserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImplementation(application)
}