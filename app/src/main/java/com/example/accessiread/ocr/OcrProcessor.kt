package com.example.accessiread.ocr

import android.graphics.Bitmap
import com.example.accessiread.data.model.OcrBlock
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class OcrProcessor @Inject constructor {
    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    suspend fun extract(bitmap: Bitmap): List<OcrBlock> {
        val text = recognizer.process(InputImage.fromBitmap(bitmap, 0)).await()
        return text.textBlocks.map { OcrBlock(it.text, it.boundingBox) }
    }
}
