package com.example.accessiread.data.model

import android.graphics.Rect

enum class AppLanguage { ENGLISH, MARATHI }
enum class ReadingMode { LATEST_MESSAGE, FULL_SCREEN }

data class OcrBlock(val text: String, val bounds: Rect?)

data class ScanResult(
    val original: String,
    val translated: String,
    val summary: String? = null,
    val sourcePackage: String? = null,
    val timestamp: Long = System.currentTimeMillis()
)

data class UserSettings(
    val language: AppLanguage = AppLanguage.ENGLISH,
    val autoRead: Boolean = false,
    val continuousMode: Boolean = false,
    val defaultMode: ReadingMode = ReadingMode.FULL_SCREEN,
)
