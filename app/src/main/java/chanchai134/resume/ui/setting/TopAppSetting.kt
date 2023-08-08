package chanchai134.resume.ui.setting

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import chanchai134.resume.R
import chanchai134.resume.ui.theme.ResumeandroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppSetting(
    @StringRes title: Int,
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
        title = { Text(stringResource(title)) },
        actions = {
            IconButton({ onSwitchMode(displaySwitchMode)}) {
                Icon(
                    painterResource(displaySwitchMode.icon),
                    contentDescription = displaySwitchMode.name,
                    modifier = Modifier.width(dimensionResource(R.dimen.icon)).aspectRatio(1f)
                )
            }
            IconButton({ onSwitchLanguage(displaySwitchLanguage)}) {
                Text(displaySwitchLanguage.display)
            }
        }
    )
}

@Preview("LightMode", showBackground = true)
@Composable
fun TopAppSettingPreview() {
    ResumeandroidTheme {
        TopAppSetting(R.string.app_name ,Language.EN, {}, Mode.Light, {})
    }
}

@Preview("DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun TopAppSettingDarkThemePreview() {
    ResumeandroidTheme {
        TopAppSetting(R.string.app_name, Language.EN, {}, Mode.Dark, {})
    }
}
