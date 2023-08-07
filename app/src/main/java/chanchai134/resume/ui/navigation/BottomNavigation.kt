package chanchai134.resume.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun BottomNavigation(
    selectedMenu: Destination,
    menus: List<Destination>,
    navigate: (Destination) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier) {
        menus.forEach {
            val label = stringResource(it.label)
            NavigationBarItem(
                icon = { Icon(it.icon, contentDescription = label) },
                label = { Text(label) },
                selected = selectedMenu.route == it.route,
                onClick = { navigate(it) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    ResumeandroidTheme {
        BottomNavigation(Destination.getAll()[0], Destination.getAll(), {})
    }
}
