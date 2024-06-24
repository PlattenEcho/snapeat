package com.bangkit.snapeat.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bangkit.snapeat.domain.manager.LocalUserManager
import com.bangkit.snapeat.domain.manager.UserInformation
import com.bangkit.snapeat.util.Constants
import com.bangkit.snapeat.util.Constants.USER_SETTINGS
import dagger.Module
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Module
class LocalUserManagerImplementation(
    private val context: Context
): LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit{ settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map{preferences ->
            preferences[PreferencesKeys.APP_ENTRY]?:false
        }
    }

    override suspend fun saveToken(token: String) {
        context.dataStore.edit{ settings ->
            settings[PreferencesKeys.USER_TOKEN] = token
        }
    }

    override fun readToken(): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.USER_TOKEN]
        }
    }

    override suspend fun saveUserInformation(
        email: String,
        uid: String,
        displayName: String,
        photoURL: String
    ): Preferences {
        return context.dataStore.edit{ settings ->
            settings[PreferencesKeys.USER_EMAIL] = email
            settings[PreferencesKeys.USER_UID] = uid
            settings[PreferencesKeys.USER_DISPLAY_NAME] = displayName
            settings[PreferencesKeys.USER_PHOTO_URL] = photoURL
        }
    }

    override fun readUserInformation(): Flow<UserInformation> {
        return context.dataStore.data.map { preferences ->
            UserInformation(
                email = preferences[PreferencesKeys.USER_EMAIL]?:"",
                uid = preferences[PreferencesKeys.USER_UID]?:"",
                displayName = preferences[PreferencesKeys.USER_DISPLAY_NAME]?:"",
                photoURL = preferences[PreferencesKeys.USER_PHOTO_URL]?:""
            )
        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
    val USER_TOKEN = stringPreferencesKey(name = Constants.TOKEN)
    val USER_EMAIL = stringPreferencesKey(name = Constants.EMAIL)
    val USER_UID = stringPreferencesKey(name = Constants.UID)
    val USER_DISPLAY_NAME = stringPreferencesKey(name = Constants.DISPLAY_NAME)
    val USER_PHOTO_URL = stringPreferencesKey(name = Constants.PHOTO_URL)
}