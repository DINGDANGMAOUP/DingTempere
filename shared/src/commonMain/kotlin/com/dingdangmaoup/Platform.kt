package com.dingdangmaoup

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform