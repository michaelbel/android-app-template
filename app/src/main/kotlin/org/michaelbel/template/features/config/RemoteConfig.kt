package org.michaelbel.template.features.config

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.michaelbel.template.R
import org.michaelbel.template.ui.AppTheme

typealias OnNavigationIconClick = () -> Unit

@Composable
fun RemoteConfig(onNavigationIconClick: OnNavigationIconClick) {
    AppTheme {
        Column {
            RemoteConfigTopBar(onNavigationIconClick = onNavigationIconClick)
            RemoteConfigBox()
        }
    }
}

@Composable
fun RemoteConfigTopBar(
    modifier: Modifier = Modifier,
    onNavigationIconClick: OnNavigationIconClick
) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.title_remote_config)) },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_back)
                )
            }
        },
        modifier = modifier,
        elevation = 2.dp
    )
}

@Composable
fun RemoteConfigBox(
    modifier: Modifier = Modifier,
) {
    val viewModel = viewModel(RemoteConfigViewModel::class.java)

    Box(modifier = modifier.fillMaxWidth(1F)) {
        LazyColumn {
            item {
                OutlinedButton(
                    onClick = { viewModel.takeBooleanParam() },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.button_fetch_boolean)) }
            }
            item {
                OutlinedButton(
                    onClick = { viewModel.takeStringParam() },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
                ) { Text(text = stringResource(R.string.button_fetch_string)) }
            }
            item {
                OutlinedButton(
                    onClick = { viewModel.takeNumberParam() },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 16.dp)
                ) { Text(text = stringResource(R.string.button_fetch_number)) }
            }
        }
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RemoteConfigPreview() {
    RemoteConfig {}
}