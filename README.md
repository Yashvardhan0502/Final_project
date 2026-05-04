# AccesiRead Android App (MVVM + Compose)

Accessibility-focused Android app scaffold to read, translate (English ↔ Marathi), and simplify on-screen content.

## What is now improved
- Replaced thin placeholders with safer baseline behavior for foreground service notifications.
- Added richer persisted settings model (`language`, `autoRead`, `continuousMode`, `defaultMode`) via DataStore.
- Updated MVVM state flow so UI observes persisted settings in real-time.
- Added setup toggles for auto-read and continuous mode in Compose screen.
- Added runtime overlay permission entry point and service startup from activity.

## Implemented modules
- UI (Compose + ViewModel)
- FloatingService (foreground lifecycle + notification channel)
- Capture module placeholder (MediaProjection integration point)
- OCR module (ML Kit Text Recognition)
- AI module placeholder (translation + summarization extension point)
- TTS module (English/Marathi locale + speed/pitch)
- Voice command module
- Storage module (DataStore + Room history)

## Remaining production tasks
- Complete bubble gestures (single tap, long press, double tap).
- Implement MediaProjection capture pipeline + bitmap conversion.
- Implement app-aware read defaults and latest-message bounding box overlay.
- Add offline ML Kit translation model management and cloud summarization client.
- Add robust tests and monitoring.
