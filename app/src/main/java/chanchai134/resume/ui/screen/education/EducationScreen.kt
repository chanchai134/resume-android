package chanchai134.resume.ui.screen.education

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import chanchai134.resume.R
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun EducationScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<EducationViewModel>()

    Screen(viewModel.uiState, modifier.fillMaxSize())
}

@Composable
private fun Screen(uiState: EducationUiState, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier
            .padding(horizontal = dimensionResource(R.dimen.padding))
            .verticalScroll(scrollState)
    ) {
        Head()
        Divider()
        uiState.allEducation.forEach {
            Item(
                stringResource(it.description),
                stringResource(it.range)
            )
        }
    }
}

@Composable
private fun Head(modifier: Modifier = Modifier) {
    Row(
        modifier.padding(vertical = dimensionResource(R.dimen.semi_padding)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(R.drawable.ic_education),
            null,
            Modifier
                .padding(end = dimensionResource(R.dimen.semi_padding))
                .width(dimensionResource(R.dimen.icon))
                .aspectRatio(1f)
        )
        Text(
            stringResource(R.string.education_bg),
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
private fun Item(description: String, range: String, modifier: Modifier = Modifier) {
    Row(
        modifier.padding(dimensionResource(R.dimen.semi_padding)),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            description,
            Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            range,
            Modifier.padding(start = dimensionResource(R.dimen.padding_1_5_x)),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview("Light", showBackground = true)
@Preview("Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ScreenPreview() {
    ResumeandroidTheme {
        Screen(EducationUiState(listOf(
            EducationUiState.Education(R.string.education_2_description, R.string.education_2_range)
        )))
    }
}
