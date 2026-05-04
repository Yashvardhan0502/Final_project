package com.example.accessiread.tts

import android.speech.tts.TextToSpeech
import com.example.accessiread.data.model.AppLanguage
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import android.content.Context

class TtsManager @Inject constructor(@ApplicationContext context: Context) {
    private val tts = TextToSpeech(context) { }
    fun speak(text: String, lang: AppLanguage, speed: Float = 1f, pitch: Float = 1f) {
        tts.language = if (lang == AppLanguage.MARATHI) Locale("mr", "IN") else Locale.US
        tts.setSpeechRate(speed)
        tts.setPitch(pitch)
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "read")
    }
}
