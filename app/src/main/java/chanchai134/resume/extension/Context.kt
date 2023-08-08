package chanchai134.resume.extension

import android.app.LocaleManager
import android.content.Context
import android.os.LocaleList
import chanchai134.resume.ui.setting.Language

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