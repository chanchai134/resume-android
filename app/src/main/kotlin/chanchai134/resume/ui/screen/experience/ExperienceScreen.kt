package chanchai134.resume.ui.screen.experience

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import chanchai134.resume.R
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun ExperienceScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<ExperienceViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    Screen(uiState, viewModel::setJobByIndex, modifier)
}

@Composable
private fun Screen(
    uiState: ExperienceUiState,
    setJobByIndex: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = uiState.selectedIndex) {
            uiState.rangeTitleTab.forEachIndexed { index, i ->
                Tab(
                    selected = index == uiState.selectedIndex,
                    onClick = {
                        if (index != uiState.selectedIndex) setJobByIndex(index)
                    },
                    text = { Text(stringResource(i)) }
                )
            }
        }
        Body(uiState, Modifier.padding(horizontal = dimensionResource(R.dimen.padding)))
    }
}

@Composable
private fun Body(
    uiState: ExperienceUiState,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    LazyColumn(
        modifier,
        listState,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.semi_padding))
    ) {
        item {
            Position(
                stringResource(uiState.title),
                stringResource(uiState.duration),
                Modifier.padding(top = dimensionResource(R.dimen.padding))
            )
        }
        item {
            Company(
                stringResource(uiState.company),
                Modifier.padding(start = dimensionResource(R.dimen.padding_3_x))
            )
        }
        item {
            JobDetail(
                stringResource(uiState.jobDetail),
                Modifier.padding(start = dimensionResource(R.dimen.padding_1_5_x))
            )
        }
        item {
            RelatedSkill(
                uiState.skills,
                Modifier.padding(
                    start = dimensionResource(R.dimen.padding_1_5_x),
                    bottom = dimensionResource(R.dimen.two_third_padding)
                )
            )
        }
    }
}

@Composable
private fun Position(title: String, exp: String, modifier: Modifier = Modifier) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painterResource(R.drawable.ic_exp), null,
            Modifier
                .padding(end = dimensionResource(R.dimen.semi_padding))
                .width(dimensionResource(R.dimen.icon))
                .aspectRatio(1f)
        )
        Text(
            buildAnnotatedString {
                pushStyle(MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium).toSpanStyle())
                append(title)
                pop()
                pushStyle(MaterialTheme.typography.bodyLarge.copy(fontStyle = FontStyle.Italic).toSpanStyle())
                append("  ")
                append("($exp)")
            }
        )
    }
}

@Composable
private fun Company(company: String, modifier: Modifier = Modifier) {
    Text(
        "@ $company",
        modifier,
        style = MaterialTheme.typography.bodyLarge,
        fontStyle = FontStyle.Italic
    )
}

@Composable
private fun JobDetail(detail: String, modifier: Modifier = Modifier) {
    Text(
        "    $detail",
        modifier,
        style = MaterialTheme.typography.bodyLarge
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun RelatedSkill(skills: List<Int>, modifier: Modifier = Modifier) {
    FlowRow(modifier) {
        skills.forEach {
            Card(
                Modifier.padding(
                    end = dimensionResource(R.dimen.one_third_padding),
                    bottom = dimensionResource(R.dimen.one_third_padding)
                ),
                MaterialTheme.shapes.small
            ) {
                Box(Modifier.height(dimensionResource(R.dimen.padding_1_5_x)), Alignment.Center) {
                    Text(
                        stringResource(it),
                        Modifier.padding(horizontal = dimensionResource(R.dimen.semi_padding)),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Preview("LightMode", showBackground = true)
@Preview("DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun ScreenPreview() {
    ResumeandroidTheme {
        Surface {
            Screen(
                ExperienceUiState(
                    0,listOf(R.string.job_2_range, R.string.job_1_range),
                    R.string.job_2_title,
                    R.string.job_2_duration,
                    R.string.job_2_company,
                    R.string.job_2_detail,
                    listOf(R.string.ddd)
                ),
                {}
            )
        }
    }
}

@Preview("LightMode", showBackground = true)
@Preview("DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun BodyPreview() {
    ResumeandroidTheme {
        Surface {
            Body(
                ExperienceUiState(
                    0,listOf(),
                    R.string.job_2_title,
                    R.string.job_2_duration,
                    R.string.job_2_company,
                    R.string.job_2_detail,
                    listOf(R.string.ddd)
                ),
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.padding))
            )
        }
    }
}
