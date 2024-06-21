package com.bangkit.snapeat.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bangkit.snapeat.domain.manager.LocalUserManager
import com.bangkit.snapeat.util.Constants
import com.bangkit.snapeat.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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

}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
    val USER_TOKEN = stringPreferencesKey(name = Constants.TOKEN)

}