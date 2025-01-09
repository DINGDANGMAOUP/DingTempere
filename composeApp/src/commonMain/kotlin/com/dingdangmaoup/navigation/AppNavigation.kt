package com.dingdangmaoup.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dingdangmaoup.pages.FirstPage
import com.dingdangmaoup.pages.SecondPage


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first_page") {
        composable("first_page") { FirstPage(navController)  }
        composable("second_page") { SecondPage(navController) }
    }
}