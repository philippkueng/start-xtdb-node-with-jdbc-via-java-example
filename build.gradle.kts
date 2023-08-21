plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.xtdb:xtdb-core:1.24.0")
    implementation("com.xtdb:xtdb-jdbc:1.24.0")
    implementation("org.postgresql:postgresql:42.6.0")
    testImplementation(kotlin("test"))

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}