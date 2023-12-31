plugins {
	java
	`maven-publish`
	id("io.spring.dependency-management") version "1.1.2"
	id("com.github.davidmc24.gradle.plugin.avro") version "1.8.0"
	id("com.intershop.gradle.scmversion") version "6.2.0"
}

scm {
	version {
		type = "threeDigits"
		initialVersion = "0.1.0"
	}
}

group = "com.matheus"
version = scm.version.version

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			artifactId = "ecommerce-messaging-schema-registry"
			from(components["java"])
		}
	}

	repositories {
		mavenLocal()
	}
}

dependencies {
	implementation("org.springframework:spring-messaging:6.0.9")
	implementation("org.apache.avro:avro:1.11.2")
}

tasks.withType<Jar> {
	archiveBaseName.set("ecommerce-messaging-schema-registry")
}

tasks.named<Copy>("processResources") {
	from("src/main/avro") {
		include("**/*.asvc")
	}
}
