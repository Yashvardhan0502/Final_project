package com.example.accessiread.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.accessiread.data.model.AppLanguage
import com.example.accessiread.data.model.ReadingMode
import com.example.accessiread.data.model.UserSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("settings")

class SettingsStore(private val context: Context) {
    private val langKey = stringPreferencesKey("lang")
    private val autoReadKey = booleanPreferencesKey("auto_read")
    private val continuousKey = booleanPreferencesKey("continuous")
    private val defaultModeKey = stringPreferencesKey("default_mode")

    val settings: Flow<UserSettings> = context.dataStore.data.map { pref ->
        UserSettings(
            language = AppLanguage.valueOf(pref[langKey] ?: AppLanguage.ENGLISH.name),
            autoRead = pref[autoReadKey] ?: false,
            continuousMode = pref[continuousKey] ?: false,
            defaultMode = ReadingMode.valueOf(pref[defaultModeKey] ?: ReadingMode.FULL_SCREEN.name)
        )
    }

    suspend fun setLanguage(language: AppLanguage) = context.dataStore.edit { it[langKey] = language.name }
    suspend fun setAutoRead(enabled: Boolean) = context.dataStore.edit { it[autoReadKey] = enabled }
    suspend fun setContinuous(enabled: Boolean) = context.dataStore.edit { it[continuousKey] = enabled }
    suspend fun setDefaultMode(mode: ReadingMode) = context.dataStore.edit { it[defaultModeKey] = mode.name }
}
