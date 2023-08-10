package chanchai134.resume.ui

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import chanchai134.resume.R
import chanchai134.resume.ui.theme.ResumeandroidTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    ConstraintLayout(
        modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        val (imageRef, textRef, footerRef) = createRefs()
        val padding = dimensionResource(R.dimen.padding)

        Image(
            painter = painterResource(R.drawable.portrait),
            contentScale = ContentScale.Fit,
            contentDescription = "owner portrait",
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
            text = stringResource(R.string.greetings),
            style = MaterialTheme.typography.titleLarge,
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

        Information(modifier.constrainAs(footerRef) {
            bottom.linkTo(parent.bottom,padding)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}

@Composable
private fun Information(modifier: Modifier = Modifier) {
    Column(modifier.width(IntrinsicSize.Max)) {
        Text(
            text = stringResource(R.string.full_name),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(dimensionResource(R.dimen.semi_padding))
        )
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CircleIcon(R.drawable.ic_phone, R.string.call, {})
            CircleIcon(R.drawable.ic_mail, R.string.e_mail, {})
            CircleIcon(R.drawable.ic_github, R.string.github, {})
            CircleIcon(R.drawable.ic_linkedin, R.string.linkedin, {})
        }
    }
}

@Composable
fun CircleIcon(
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
fun InformationPreview() {
    ResumeandroidTheme {
        Information()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ResumeandroidTheme {
        HomeScreen()
    }
}
