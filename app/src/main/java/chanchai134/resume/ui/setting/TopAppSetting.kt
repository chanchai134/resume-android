package chanchai134.resume.ui.setting

import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import chanchai134.resume.ui.theme.ResumeandroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppSetting(
    currentLanguage: Language,
    onSwitchLanguage: (Language) -> Unit,
    currentMode: Mode,
    onSwitchMode: (Mode) -> Unit,
    modifier: Modifier = Modifier
) {
    val displaySwitchLanguage = if(currentLanguage == Language.EN) Language.TH else Language.EN
    val displaySwitchMode = if(currentMode == Mode.Light) Mode.Dark else Mode.Light

    TopAppBar(
        modifier = modifier,
        title = {},
        actions = {
            IconButton({ onSwitchMode(displaySwitchMode)}) {
                Icon(displaySwitchMode.icon, contentDescription = displaySwitchMode.name)
            }
            IconButton({ onSwitchLanguage(displaySwitchLanguage)}) {
                Text(displaySwitchLanguage.display)
            }
        }
    )
}

@Preview("Light Theme", showBackground = true)
@Composable
fun TopAppSettingPreview() {
    ResumeandroidTheme {
        TopAppSetting(Language.EN, {}, Mode.Light, {})
    }
}

@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun TopAppSettingDarkThemePreview() {
    ResumeandroidTheme {
        TopAppSetting(Language.EN, {}, Mode.Dark, {})
    }
}
