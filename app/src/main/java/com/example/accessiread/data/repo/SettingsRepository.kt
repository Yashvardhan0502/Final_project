package com.example.accessiread.data.repo

import com.example.accessiread.data.datastore.SettingsStore
import com.example.accessiread.data.model.AppLanguage
import com.example.accessiread.data.model.ReadingMode
import javax.inject.Inject

class SettingsRepository @Inject constructor(private val store: SettingsStore) {
    val settings = store.settings
    suspend fun saveLanguage(language: AppLanguage) = store.setLanguage(language)
    suspend fun setAutoRead(enabled: Boolean) = store.setAutoRead(enabled)
    suspend fun setContinuous(enabled: Boolean) = store.setContinuous(enabled)
    suspend fun setDefaultMode(mode: ReadingMode) = store.setDefaultMode(mode)
}
