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
package com.example.androiddevchallenge.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.screen.home.HomeScreen
import com.example.androiddevchallenge.ui.screen.login.LoginScreen
import com.example.androiddevchallenge.ui.screen.login.WelcomeScreen

@Composable
fun MainStack() {
    val navController = rememberNavController()
    val routeWelcome = stringResource(id = R.string.route_welcome)
    val routeLogin = stringResource(id = R.string.route_login)
    val routeHome = stringResource(id = R.string.route_home)

    NavHost(navController, startDestination = routeWelcome) {
        composable(route = routeWelcome) {
            WelcomeScreen(
                onNext = { navController.navigate(routeLogin) }
            )
        }
        composable(route = routeLogin) {
            LoginScreen(
                onNext = { navController.navigate(routeHome) }
            )
        }
        composable(route = routeHome) {
            HomeScreen()
        }
    }
}
