package chanchai134.resume.ui.screen.skill

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import chanchai134.resume.R
import chanchai134.resume.ui.LightDarkPreviews
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun SkillScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<SkillViewModel>()

    Screen(viewModel.uiState, modifier)
}

@Composable
private fun Screen(uiState: SkillSetUiState, modifier: Modifier = Modifier) {
    val semiPadding = dimensionResource(R.dimen.semi_padding)

    LazyVerticalGrid(GridCells.Fixed(2),
        modifier
            .fillMaxSize()
            .padding(
                horizontal = dimensionResource(R.dimen.padding)
            )
    ) {
        uiState.allSkill.forEach {
            skillList(it.title, it.icon, it.skills)
        }
        padding(semiPadding)
    }
}

private fun LazyGridScope.skillList(title: Int, icon: Int, skills: List<Int>) {
    item(span = { GridItemSpan(maxLineSpan) }) {
        Column {
            Row(
                Modifier.padding(vertical = dimensionResource(R.dimen.semi_padding)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(icon),
                    null,
                    Modifier
                        .padding(end = dimensionResource(R.dimen.semi_padding))
                        .width(dimensionResource(R.dimen.icon))
                        .aspectRatio(1f)
                )
                Text(
                    stringResource(title),
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Divider()
        }
    }
    items(skills) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(" • ", style = MaterialTheme.typography.headlineLarge)
            Text(
                text = stringResource(it),
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

private fun LazyGridScope.padding(size: Dp) {
    item(span = { GridItemSpan(maxLineSpan) }) {
        Spacer(modifier = Modifier.padding(bottom = size))
    }
}

@LightDarkPreviews
@Composable
private fun ScreenPreview() {
    ResumeandroidTheme {
        Surface {
            Screen(SkillSetUiState(listOf(
                SkillSetUiState.Skill(
                    R.string.android,
                    R.drawable.ic_android,
                    listOf(
                        R.string.kotlin,
                        R.string.android_studio,
                        R.string.view,
                        R.string.view_binding,
                    )
                ),
                SkillSetUiState.Skill(
                    R.string.back_end_eveloper,
                    R.drawable.ic_backend,
                    listOf(
                        R.string.node_js,
                        R.string.typescript,
                        R.string.javascript,
                        R.string.ddd
                    )
                )
            )))
        }
    }
}
