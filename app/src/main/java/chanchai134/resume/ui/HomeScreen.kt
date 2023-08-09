package chanchai134.resume.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        val (imageRef, textRef) = createRefs()

        Image(
            painter = painterResource(R.drawable.portrait),
            contentScale = ContentScale.Fit,
            contentDescription = "owner portrait",
            modifier = Modifier
                .width(280.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(140.dp))
                .constrainAs(imageRef) {
                    top.linkTo(parent.top,24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = stringResource(R.string.greetings),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(horizontal = 24.dp)
                .wrapContentSize()
                .constrainAs(textRef) {
                    top.linkTo(imageRef.bottom,24.dp)
                    bottom.linkTo(parent.bottom,24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ResumeandroidTheme {
        HomeScreen()
    }
}
