package com.bangkit.snapeat.domain.usecases

import com.bangkit.snapeat.domain.manager.LocalUserManager
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

class ReadAppEntry (
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}