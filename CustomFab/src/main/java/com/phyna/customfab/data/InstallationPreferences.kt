package com.phyna.customfab.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_preferences")

class InstallationPreferences (context: Context) {

    private val appContext = context.applicationContext

    val installationTime: Flow<String?>
        get() = appContext.dataStore.data.map { preferences ->
            preferences[KEY]
        }


    suspend fun saveInstallationTime(time: String) {
        appContext.dataStore.edit { preferences ->
            preferences[KEY] = time
        }
    }

    suspend fun removeInstallationTime() {
        appContext.dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private val KEY = stringPreferencesKey("key")
    }

}
