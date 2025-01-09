package com.dingdangmaoup.ui


import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.dingdangmaoup.pages.FirstPage
import com.dingdangmaoup.pages.SecondPage
import com.dingdangmaoup.ui.message.MessagePage
import com.dingdangmaoup.ui.message.UserPage


@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "1",
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        //固定路由
        composable("1") { FirstPage(navController) }
        composable("2") { SecondPage(navController) }

        composable("3") {
            MessagePage(modifier)
        }
        composable("4") {
            UserPage(modifier)
        }
    }
}



