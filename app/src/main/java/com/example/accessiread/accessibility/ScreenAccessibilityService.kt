package com.example.accessiread.accessibility

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class ScreenAccessibilityService : AccessibilityService() {
    @Volatile var currentPackage: String = ""

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        currentPackage = event?.packageName?.toString().orEmpty()
    }

    override fun onInterrupt() = Unit
}
