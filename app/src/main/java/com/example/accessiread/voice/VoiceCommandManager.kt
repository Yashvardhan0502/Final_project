package com.example.accessiread.voice

import javax.inject.Inject

class VoiceCommandManager @Inject constructor() {
    fun parse(command: String): VoiceAction = when {
        command.contains("translate", true) -> VoiceAction.TRANSLATE
        command.contains("summarize", true) -> VoiceAction.SUMMARIZE
        else -> VoiceAction.READ
    }
}

enum class VoiceAction { READ, TRANSLATE, SUMMARIZE }
