package com.bangkit.snapeat.domain.manager

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

data class UserInformation(
    val email: String,
    val uid: String,
    val displayName: String,
    val photoURL: String
)

interface LocalUserManager {

    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>

    suspend fun saveToken(token: String)

    fun readToken(): Flow<String?>

    suspend fun saveUserInformation(email: String, uid: String, displayName: String, photoURL: String): Preferences

    fun readUserInformation(): Flow<UserInformation>
}