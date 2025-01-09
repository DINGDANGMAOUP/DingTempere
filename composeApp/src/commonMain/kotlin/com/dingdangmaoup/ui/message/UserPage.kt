package com.dingdangmaoup.ui.message

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.alexzhirkevich.cupertino.CupertinoScaffold
import io.github.alexzhirkevich.cupertino.CupertinoText
import io.github.alexzhirkevich.cupertino.CupertinoTopAppBar
import io.github.alexzhirkevich.cupertino.ExperimentalCupertinoApi

@OptIn(ExperimentalCupertinoApi::class)
@Composable
fun UserPage(modifier: Modifier = Modifier) {
        CupertinoScaffold(
            modifier = modifier,
            topBar = {
                CupertinoTopAppBar(
                    title = {
                        CupertinoText("User")
                    }
                )
            }
        ) {
                CupertinoText("this is user page")
        }
}