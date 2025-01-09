package com.dingdangmaoup.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier


import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.dingdangmaoup.theme.DingTempereTheme
import io.github.alexzhirkevich.cupertino.*


data class AppTabs(val route: String, val title: String)


@OptIn(ExperimentalCupertinoApi::class)
@Composable
fun App() {
    DingTempereTheme {
        val isOutlined by remember {
            mutableStateOf(true)
        }

        val pagerState = rememberPagerState(
            pageCount = { 2 }
        )

        LaunchedEffect(isOutlined) {
            pagerState.animateScrollToPage(if (isOutlined) 0 else 1)
        }
        val navController = rememberNavController()
        val tabs = remember {
            listOf(
                AppTabs("1", "tab1"), AppTabs("2", "tab2"),
                AppTabs("3", "消息"), AppTabs("4", "用户")
            )
        }
//        val tabs = remember { CourseTabs.values() }
        CupertinoScaffold(
//            topBar = {
//                CupertinoTopAppBar(
//                    navigationIcon = {
//                        CupertinoNavigateBackButton(
//                            onClick = {
//                                navController.currentBackStack
//                            },
//                        ) {
//                            CupertinoText("Back")
//                        }
//                    },
//                    title = {
//                        CupertinoSegmentedControl(
//                            modifier = Modifier
//                                .width(200.dp),
//                            selectedTabIndex = if (isOutlined) 0 else 1
//                        ) {
//                            CupertinoSegmentedControlTab(
//                                isSelected = isOutlined,
//                                onClick = {
//                                    isOutlined = true
//                                }
//                            ) {
//                                CupertinoText("Outlined")
//                            }
//                            CupertinoSegmentedControlTab(
//                                isSelected = !isOutlined,
//                                onClick = {
//                                    isOutlined = false
//
//                                }
//                            ) {
//                                CupertinoText("Filled")
//                            }
//                        }
//                    }
//                )
//            },
            bottomBar = {
                AppBottomBar(navController, tabs)
            }
        ) { innerPaddingModifier ->
            NavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPaddingModifier)
            )

        }


    }
}

@OptIn(ExperimentalCupertinoApi::class)
@Composable
fun AppBottomBar(navController: NavController, tabs: List<AppTabs>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val route = navBackStackEntry?.destination?.route
    CupertinoNavigationBar {
        tabs.forEach {
            CupertinoNavigationBarItem(
                selected = route === it.route,
                label = {
                    CupertinoText(it.title)
                },
                onClick = {
                    navController.navigate(it.route)
                },
                icon = { CupertinoIcon(
                    imageVector =Icons.AutoMirrored.Default.List,
                    contentDescription = null,
                ) },

                )
        }
    }
}

//@Composable
//fun OwlBottomBar(navController: NavController, tabs: Array<AppTabs>) {
//
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
//        ?: CourseTabs.FEATURED.route
//
//    val routes = remember { CourseTabs.values().map { it.route } }
//    if (currentRoute in routes) {
//        BottomNavigation(
//            Modifier.windowInsetsBottomHeight(
//                WindowInsets.navigationBars.add(WindowInsets(bottom = 56.dp))
//            )
//        ) {
//            tabs.forEach { tab ->
//                BottomNavigationItem(
//                    icon = { },
//                    label = { Text("1") },
//                    selected = currentRoute == tab.route,
//                    onClick = {
//                        if (tab.route != currentRoute) {
//                            navController.navigate(tab.route) {
//                                popUpTo(navController.graph.startDestinationId) {
//                                    saveState = true
//                                }
//                                launchSingleTop = true
//                                restoreState = true
//                            }
//                        }
//                    },
//                    alwaysShowLabel = false,
//                    selectedContentColor = MaterialTheme.colors.secondary,
//                    unselectedContentColor = LocalContentColor.current,
//                    modifier = Modifier.navigationBarsPadding()
//                )
//            }
//        }
//    }
//}