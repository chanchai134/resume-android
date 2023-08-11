package chanchai134.resume.ui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun EducationScreen(
    modifier: Modifier = Modifier
) {

}

@Preview("Light", showBackground = true)
@Preview("Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EducationScreenPreview() {
    ResumeandroidTheme {
        EducationScreen()
    }
}
