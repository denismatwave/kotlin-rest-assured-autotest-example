plugins {
    kotlin("jvm") version "1.9.22"
}

group = "qa.denismatwave.automation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.10.2"
dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // junit
    implementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}