package com.dingdangmaoup.utils

import co.touchlab.kermit.Logger

class LogUtil {
    companion object{
        private val log=Logger.withTag("DingTempere")

        fun info(message: String) {
            log.i(message)
        }
        fun error(message: String) : Unit {
            log.e(message)
        }
    }
}

