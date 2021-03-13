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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil.transform.Transformation
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun RemoteImage(
    uri: String,
    contentDescription: String,
    modifier: Modifier,
    transformation: Transformation? = null
) {
    Box(modifier = modifier) {
        CoilImage(
            data = uri,
            contentDescription = contentDescription,
            loading = {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            },
            requestBuilder = {
                transformation?.run {
                    transformations(transformation)
                } ?: transformations()
            },
            error = {
                Box(Modifier.matchParentSize()) {
                    Image(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(id = R.drawable.ic_error),
                        contentDescription = "error loading $contentDescription",
                    )
                }
            }
        )
    }
}
