package org.michaelbel.template.features.inappreview.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldState
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.OnNavigationBackClick
import org.michaelbel.template.R

typealias OnButtonClick = () -> Unit

@Composable
fun ReviewScreen(
    onButtonClick: OnButtonClick,
    onNavigationBackClick: OnNavigationBackClick,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { Toolbar(onNavigationBackClick) }
    ) { Content(onButtonClick = onButtonClick) }
}

@Composable
private fun Toolbar(onNavigationBackClick: OnNavigationBackClick) {
    SmallTopAppBar(
        title = { Text(stringResource(id = R.string.title_in_app_review)) },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = onNavigationBackClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_back)
                )
            }
        }
    )
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    onButtonClick: OnButtonClick
) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            item {
                OutlinedButton(
                    onClick = { onButtonClick() },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.title_in_app_review)) }
            }
        }
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ReviewScreenPreview() {
    ReviewScreen(
        onButtonClick = {},
        onNavigationBackClick = {}
    )
}