package chanchai134.resume.ui

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import chanchai134.resume.R
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun SkillScreen(modifier: Modifier = Modifier) {
    val semiPadding = dimensionResource(R.dimen.semi_padding)

    LazyVerticalGrid(GridCells.Fixed(2),
        modifier
            .fillMaxSize()
            .padding(
                horizontal = dimensionResource(R.dimen.padding)
            )
    ) {
        skillList(R.string.app_name, R.drawable.ic_android, listOf(R.string.app_name,R.string.call, R.string.linkedin, R.string.github, R.string.app_name))
        skillList(R.string.app_name, R.drawable.ic_backend, listOf(R.string.app_name,R.string.call, R.string.linkedin, R.string.github, R.string.app_name))
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

@Preview(showBackground = true)
@Composable
private fun SkillScreenPreview() {
    ResumeandroidTheme {
        SkillScreen()
    }
}
