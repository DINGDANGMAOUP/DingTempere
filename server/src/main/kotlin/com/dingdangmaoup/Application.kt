package com.dingdangmaoup

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.ratelimit.*
import kotlin.time.Duration.Companion.seconds

fun main() {

    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(RateLimit){
        register {
            rateLimiter(limit = 5, refillPeriod = 60.seconds)
        }
        register(RateLimitName("api-v1")){
            rateLimiter(limit = 5, refillPeriod = 60.seconds)
        }
    }
    routing {
        rateLimit {
            get("/") {
                val requestsLeft = call.response.headers["X-RateLimit-Remaining"]
                call.respondText("Ktor: ${Greeting().greet()},rate: $requestsLeft")
            }
        }
        rateLimit(RateLimitName("api-v1")) {
            get("/v1") {
                val cookies = call.request.cookies.rawCookies
                log.info("cookies : $cookies")
                val requestsLeft = call.response.headers["X-RateLimit-Remaining"]
                call.respondText("Ktor-v1: ${Greeting().greet()},rate: $requestsLeft")

            }
        }
    }
}