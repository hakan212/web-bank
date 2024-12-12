import kotlin.collections.mapOf

plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.ktor)
	application
}

group = "webbank"
version = "0.0.1"

application {
	mainClass.set("io.ktor.server.netty.EngineMain")

	val isDevelopment: Boolean = project.ext.has("development")
	applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.ktor.server.core)
	implementation(libs.ktor.server.netty)
	implementation(libs.logback.classic)
	implementation(libs.ktor.server.config.yaml)
	testImplementation(libs.ktor.server.test.host)
	testImplementation(libs.kotlin.test.junit)
}

tasks.test {
	useJUnitPlatform()
}

tasks.jar {
	manifest {
		attributes( mapOf("Main-Class" to "webbank.ApplicationKt"))
	}
}
