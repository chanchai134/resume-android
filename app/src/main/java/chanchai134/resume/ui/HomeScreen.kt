package chanchai134.resume.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Text("home")
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ResumeandroidTheme {
        HomeScreen()
    }
}
