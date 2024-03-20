plugins {
    kotlin("jvm") version "1.9.22"
}

group = "qa.denismatwave.automation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.10.2"
val restAssuredVersion = "5.4.0"

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // junit
    implementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")

    // restAssured
    implementation("io.rest-assured:rest-assured:$restAssuredVersion")
    implementation("io.rest-assured:kotlin-extensions:$restAssuredVersion")

    implementation("io.kotest:kotest-assertions-core-jvm:5.8.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}