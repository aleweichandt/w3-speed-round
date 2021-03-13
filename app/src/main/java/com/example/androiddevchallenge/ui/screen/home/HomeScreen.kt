/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {},
        bottomBar = { HomeScreenBottomBar() }
    ) {
        HomeScreenBody()
    }
}

@Composable
fun HomeScreenBottomBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        BottomNavigation(
            modifier = Modifier.padding(top = 24.dp),
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.onBackground,
            elevation = 8.dp
        ) {
            BottomNavigationItem(
                onClick = {},
                icon = {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        painter = painterResource(id = R.drawable.ic_spa),
                        contentDescription = stringResource(id = R.string.home)
                    )
                },
                label = { Text(stringResource(id = R.string.home)) },
                selected = true
            )
            BottomNavigationItem(
                onClick = {},
                icon = {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        painter = painterResource(id = R.drawable.ic_account),
                        contentDescription = stringResource(id = R.string.profile)
                    )
                },
                label = { Text(stringResource(id = R.string.profile)) },
                selected = false,
            )
        }
        IconButton(
            onClick = {},
            modifier = Modifier
                .wrapContentSize()
                .background(color = MaterialTheme.colors.primary, shape = CircleShape)
                .align(Alignment.TopCenter)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = stringResource(id = R.string.play),
                tint = MaterialTheme.colors.onPrimary,
            )
        }
    }
}

@Composable
fun HomeScreenBody() {
    val (search, setSearch) = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        start = 16.dp, end = 16.dp, top = 8.dp, bottom = 24.dp
                    )
            ) {
                TextField(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth(),
                    value = search,
                    onValueChange = setSearch,
                    label = {
                        Text(
                            text = stringResource(id = R.string.search),
                            style = MaterialTheme.typography.body1
                        )
                    },
                    maxLines = 1,
                    textStyle = MaterialTheme.typography.body1,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        textColor = MaterialTheme.colors.onSurface,
                        leadingIconColor = MaterialTheme.colors.onSurface
                    ),
                    leadingIcon = {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.size(18.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = stringResource(id = R.string.search)
                            )
                        }
                    }
                )
            }
            CollectionsList(
                modifier = Modifier.padding(bottom = 32.dp),
                title = R.string.favorite_collections,
                items = collectionItems
            )
            AlignList(
                modifier = Modifier.padding(bottom = 32.dp),
                title = R.string.align_body,
                items = alignBodyItems
            )
            AlignList(
                modifier = Modifier.padding(bottom = 32.dp),
                title = R.string.align_mind,
                items = alignMindItems
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    MyTheme {
        HomeScreen()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreviewDark() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}
