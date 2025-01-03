plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
}

group = "com.dingdangmaoup"
version = "1.0.0"
application {
    mainClass.set("com.dingdangmaoup.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.rate.limit)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)

}