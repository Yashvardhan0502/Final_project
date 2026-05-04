package com.example.accessiread.ai

import com.example.accessiread.data.model.AppLanguage
import javax.inject.Inject

class LanguageAiModule @Inject constructor() {
    suspend fun translate(text: String, target: AppLanguage): String {
        return "[$target] $text" // TODO integrate ML Kit translation / network provider fallback
    }

    suspend fun summarize(text: String, target: AppLanguage): String {
        return "Simple summary in $target: ${text.take(120)}"
    }
}
