package chanchai134.resume.ui.screen.experience

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
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import chanchai134.resume.R
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun ExperienceScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize()) {
        val s = remember { mutableStateOf(0) }
        TabRow(selectedTabIndex = s.value) {
            Tab(
                selected = s.value == 0,
                onClick = { if(s.value != 0) s.value = 0 },
                text = { Text("July 2020 - July 2022") }
            )
            Tab(
                selected = s.value == 1,
                onClick = { if(s.value != 1) s.value = 1 },
                text = { Text("June – August 2019") }
            )
        }
        Body(Modifier.padding(horizontal = dimensionResource(R.dimen.padding)))
    }
}

@Composable
private fun Body(
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    LazyColumn(
        modifier,
        listState,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { Position(Modifier.padding(top = 24.dp)) }
        item { Company(Modifier.padding(start = 72.dp)) }
        item { JobDetail(Modifier.padding(start = 36.dp)) }
        item {
            RelatedSkill(
                listOf(R.string.app_name,R.string.call, R.string.linkedin, R.string.github, R.string.app_name,R.string.call, R.string.linkedin, R.string.github),
                Modifier.padding(start = 36.dp, bottom = 16.dp)
            )
        }
    }
}

@Composable
private fun Position(modifier: Modifier = Modifier) {
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
                append("Back-End Developer")
                pop()
                pushStyle(MaterialTheme.typography.bodyLarge.copy(fontStyle = FontStyle.Italic).toSpanStyle())
                append("  ")
                append("(2 years)")
            }
        )
    }
}

@Composable
private fun Company(modifier: Modifier = Modifier) {
    Text(
        """@ King Power Click Co., Ltd""",
        modifier,
        style = MaterialTheme.typography.bodyLarge,
        fontStyle = FontStyle.Italic
    )
}

@Composable
private fun JobDetail(modifier: Modifier = Modifier) {
    Text(
        "    ${stringResource(R.string.job_1_detail)}",
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
                Modifier.padding(end = 8.dp,bottom = 8.dp),
                MaterialTheme.shapes.small
            ) {
                Box(Modifier.height(32.dp), Alignment.Center) {
                    Text(
                        stringResource(it),
                        Modifier.padding(horizontal = 12.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExperienceScreenPreview() {
    ResumeandroidTheme {
        ExperienceScreen()
    }
}


@Preview(showBackground = true)
@Composable
private fun BodyPreview() {
    ResumeandroidTheme {
        Body(Modifier.fillMaxWidth().padding(horizontal = dimensionResource(R.dimen.padding)))
    }
}
