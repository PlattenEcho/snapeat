package com.bangkit.snapeat.domain.usecases

import com.bangkit.snapeat.domain.manager.LocalUserManager

class SaveAppEntry (
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}