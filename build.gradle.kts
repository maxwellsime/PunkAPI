val ktorVersion: String by project
val kotlinVersion: String by project
val loggingVersion: String by project
val kotestVersion: String by project
val mockkVersion: String by project

group = "com.punk"
version = "0.0.2"

application {
    mainClass.set("com.punk.ApplicationKt.main")
}

plugins {
    application
    kotlin("jvm") version "1.9.0"
    "version-catalog"
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation(libs.bundles.ktor.client)
    implementation(libs.bundles.ktor.server)
    implementation(libs.bundles.ktor.serialization)
    implementation(libs.kotlin.logging)
    implementation(libs.bundles.koin)
    implementation(libs.sl4j.logger)
    testImplementation(libs.ktor.server.test)
    testImplementation(libs.kotest)
    testImplementation(libs.mockk)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
