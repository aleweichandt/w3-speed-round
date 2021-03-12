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
package com.example.androiddevchallenge.ui.screen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun DetailsScreen(back: () -> Unit) {
    MyTheme {
        Scaffold(
            topBar = { DetailsScreenBar(back) },
        ) {
            DetailsScreenBody()
        }
    }
}

@Composable
fun DetailsScreenBar(back: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.details_screen_title))
        },
        navigationIcon = {
            IconButton(onClick = back) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(id = R.string.back)
                )
            }
        }
    )
}

@Composable
fun DetailsScreenBody() {
    Surface {
        Text(text = stringResource(id = R.string.back))
    }
}

@Preview
@Composable
fun DetailsScreenBodyWithNothing() {
    DetailsScreenBody()
}
