package com.dingdangmaoup.log

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.Severity


class CustomLog : LogWriter() {
    override fun log(severity: Severity, message: String, tag: String, throwable: Throwable?) {
        when(severity){
            Severity.Debug-> println("[debug]$tag: $message")
            Severity.Verbose -> println("[verbose]$tag: $message")
            Severity.Info -> println("[info]$tag: $message")
            Severity.Warn -> println("[warn]$tag: $message")
            Severity.Error -> println("[error]$tag: $message")
            Severity.Assert -> println("[assert]$tag: $message")
        }
    }

}

