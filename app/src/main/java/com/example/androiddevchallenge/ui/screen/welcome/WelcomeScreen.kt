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
package com.example.androiddevchallenge.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun WelcomeScreen(onNext: () -> Unit) {
    Scaffold() {
        WelcomeScreenBody(onNext = onNext)
    }
}

@Composable
fun WelcomeScreenBody(onNext: () -> Unit) {
    val isLightTheme = MaterialTheme.colors.isLight
    val bgResource = when (isLightTheme) {
        false -> R.drawable.bg_welcome_dark
        else -> R.drawable.bg_welcome
    }
    val logoResource = when (isLightTheme) {
        false -> R.drawable.ic_logo_dark
        else -> R.drawable.ic_logo
    }
    Image(
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = bgResource),
        contentDescription = ""
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(16.dp)
        ) {
            Image(
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 32.dp),
                painter = painterResource(id = logoResource),
                contentDescription = stringResource(
                    id = R.string.logo
                )
            )
            Button(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                shape = shapes.medium,
                onClick = { /*TODO*/ },
            ) {
                Text(text = stringResource(id = R.string.singup))
            }
            Button(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                shape = shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.onSecondary
                ),
                onClick = onNext,
            ) {
                Text(
                    text = stringResource(id = R.string.login)
                )
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenPreview() {
    MyTheme {
        WelcomeScreen(onNext = {})
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenPreviewDark() {
    MyTheme(darkTheme = true) {
        WelcomeScreen(onNext = {})
    }
}
