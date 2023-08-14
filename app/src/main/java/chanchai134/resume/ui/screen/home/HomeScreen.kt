package chanchai134.resume.ui.screen.home

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import chanchai134.resume.R
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val uiState = viewModel.uiState

    val scrollState = rememberScrollState()

    ConstraintLayout(
        modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        val (imageRef, textRef, footerRef) = createRefs()
        val padding = dimensionResource(R.dimen.padding)

        Image(
            painter = painterResource(uiState.portrait),
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = Modifier
                .width(dimensionResource(R.dimen.portrait_width))
                .aspectRatio(1f)
                .clip(CircleShape)
                .constrainAs(imageRef) {
                    top.linkTo(parent.top,padding)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = stringResource(uiState.greetings),
            style = MaterialTheme.typography.titleLarge.copy(
                lineHeight = MaterialTheme.typography.headlineMedium.lineHeight
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = padding)
                .wrapContentSize()
                .constrainAs(textRef) {
                    top.linkTo(imageRef.bottom,padding)
                    bottom.linkTo(footerRef.top,padding)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Information(uiState, modifier.constrainAs(footerRef) {
            bottom.linkTo(parent.bottom,padding)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}

@Composable
private fun Information(uiState: HomeUiState, modifier: Modifier = Modifier) {
    Column(modifier.width(IntrinsicSize.Max)) {
        Text(
            text = stringResource(uiState.fullName),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(dimensionResource(R.dimen.semi_padding))
        )
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val context = LocalContext.current
            val phoneNumber = stringResource(uiState.phoneNumber)
            val email = stringResource(uiState.email)
            val subjectMail = stringResource(uiState.subjectMail)
            val github = stringResource(uiState.github)
            val linkedin = stringResource(uiState.linkedin)

            CircleIcon(uiState.iconPhone, uiState.call, {
                context.startActivity(
                    Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:${phoneNumber}")
                    )
                )
            })
            CircleIcon(uiState.iconMail, uiState.sendMail, {
                context.startActivity(
                    Intent(
                        Intent.ACTION_SENDTO,
                        Uri.parse("mailto:${email}?subject=${subjectMail}")
                    )
                )
            })
            CircleIcon(uiState.iconGithub, uiState.openGithub, {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/${github}")
                    )
                )
            })
            CircleIcon(uiState.iconLinkedin, uiState.openLinkedin, {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/${linkedin}/")
                    )
                )
            })
        }
    }
}

@Composable
private fun CircleIcon(
    @DrawableRes icon: Int,
    @StringRes contentDescription: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedIconButton(onClick, modifier) {
        Icon(
            painterResource(icon),
            contentDescription = stringResource(contentDescription),
            modifier = Modifier
                .width(dimensionResource(R.dimen.icon))
                .aspectRatio(1f),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InformationPreview() {
    ResumeandroidTheme {
        Information(
            HomeUiState(
                R.drawable.portrait,
                R.drawable.ic_phone,
                R.drawable.ic_mail,
                R.drawable.ic_github,
                R.drawable.ic_linkedin,
                R.string.greetings,
                R.string.full_name,
                R.string.phone_number,
                R.string.e_mail,
                R.string.subject_mail,
                R.string.github,
                R.string.linkedin,
                R.string.call,
                R.string.send_mail,
                R.string.open_github,
                R.string.open_linkedin
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    ResumeandroidTheme {
        HomeScreen()
    }
}
