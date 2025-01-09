package com.dingdangmaoup

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.dingdangmaoup.ui.App
import com.dingdangmaoup.utils.LogUtil

fun main() = application {


    Window(
        onCloseRequest = ::exitApplication,
        title = "DingTempere",
    ) {
        LogUtil.info("init desktop")
        App()
    }
}