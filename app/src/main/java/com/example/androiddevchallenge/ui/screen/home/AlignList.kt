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

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

data class AlignItem(
    @StringRes val title: Int,
    val imageUrl: String,
)

@Composable
fun AlignList(
    @StringRes title: Int,
    items: List<AlignItem>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = stringResource(id = title),
            style = MaterialTheme.typography.h2
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        ) {
            items.forEach { item ->
                item {
                    AlignBox(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        item = item
                    )
                }
            }
        }
    }
}

@Composable
fun AlignBox(item: AlignItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.wrapContentSize()
    ) {
        Column(
            modifier = modifier.size(width = 88.dp, height = 112.dp)
        ) {
            RemoteImage(
                modifier = Modifier.size(88.dp),
                uri = item.imageUrl,
                contentDescription = stringResource(id = item.title),
                transformation = CircleCropTransformation()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    text = stringResource(id = item.title),
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                )
            }
        }
    }
}

@Preview
@Composable
fun AlignItemPreview() {
    val item = AlignItem(
        R.string.play,
        "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=100&w=100"
    )
    MyTheme {
        AlignBox(item)
    }
}

@Preview
@Composable
fun AlignItemPreviewDark() {
    val item = AlignItem(
        R.string.play,
        "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=100&w=100"
    )
    MyTheme(darkTheme = true) {
        AlignBox(item)
    }
}
