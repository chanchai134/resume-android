package chanchai134.resume.extension

import android.app.LocaleManager
import android.app.UiModeManager
import android.content.Context
import android.os.LocaleList
import chanchai134.resume.ui.setting.Language
import chanchai134.resume.ui.setting.Mode

fun Context.getCurrentLanguage(): Language {
    val localeManager = getSystemService(LocaleManager::class.java)
    val applicationLocales = localeManager.applicationLocales
    val currentLocale = if(applicationLocales.isEmpty) {
        LocaleList.getDefault().get(0)
    } else {
        applicationLocales.get(0)
    }

    return if(currentLocale.language == Language.EN.tag) Language.EN else Language.TH
}

fun Context.setLanguage(lang: Language) {
    val localeManager = getSystemService(LocaleManager::class.java)

    localeManager.applicationLocales = LocaleList.forLanguageTags(lang.tag)
}

fun Context.getCurrentMode(): Mode {
    return if(resources.configuration.isNightModeActive) Mode.Dark else Mode.Light
}

fun Context.setMode(mode: Mode) {
    val uiModeManager = getSystemService(UiModeManager::class.java)

    uiModeManager.setApplicationNightMode(when (mode) {
        Mode.Light -> UiModeManager.MODE_NIGHT_NO
        Mode.Dark -> UiModeManager.MODE_NIGHT_YES
    })
}
