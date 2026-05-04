package com.example.accessiread.capture

import android.graphics.Bitmap
import javax.inject.Inject

class ScreenCaptureManager @Inject constructor() {
    suspend fun capture(): Bitmap? = null // MediaProjection wiring point
}
