package com.example.accessiread.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accessiread.data.model.AppLanguage
import com.example.accessiread.data.model.UserSettings
import com.example.accessiread.data.repo.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class RootViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            settingsRepository.settings.collect { settings ->
                _state.update { it.copy(settings = settings) }
            }
        }
    }

    fun completeSetup(language: AppLanguage) = viewModelScope.launch {
        settingsRepository.saveLanguage(language)
        _state.update { it.copy(isSetupComplete = true) }
    }

    fun toggleAutoRead(enabled: Boolean) = viewModelScope.launch { settingsRepository.setAutoRead(enabled) }
    fun toggleContinuous(enabled: Boolean) = viewModelScope.launch { settingsRepository.setContinuous(enabled) }

    data class UiState(
        val isSetupComplete: Boolean = false,
        val settings: UserSettings = UserSettings(),
        val error: String? = null,
    )
}
