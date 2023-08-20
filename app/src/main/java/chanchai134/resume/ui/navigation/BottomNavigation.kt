package chanchai134.resume.ui.navigation

import android.content.res.Configuration
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import chanchai134.resume.R
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun BottomNavigation(
    selectedMenu: Destination,
    menus: Array<Destination>,
    navigate: (Destination) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier) {
        menus.forEach {
            val label = stringResource(it.label)
            val selected = selectedMenu.route == it.route

            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(it.icon),
                        contentDescription = label,
                        modifier = Modifier
                            .width(dimensionResource(R.dimen.icon))
                            .aspectRatio(1f)
                    )
                },
                label = { Text(label) },
                selected = selected,
                onClick = { if(!selected) navigate(it) },
                modifier = Modifier.testTag(it.route)
            )
        }
    }
}

@Preview("Light", showBackground = true)
@Preview("Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BottomNavigationPreview() {
    ResumeandroidTheme {
        BottomNavigation(Destination.Home, Destination.allDestinations, {})
    }
}
