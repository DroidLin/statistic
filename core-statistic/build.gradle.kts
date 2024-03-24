plugins {
    id("java-library")
    id("maven-publish")
}

val dependenciesGroup: String by extra
val dependenciesName: String by extra
val dependenciesVersion: String by extra

group = dependenciesGroup
version = dependenciesVersion

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    implementation("com.github.DroidLin.common:common-jvm:1.0.1")
    implementation("org.json:json:20230618")

    implementation(project(":statistic-interfaces"))
}

publishing {
    publications {
        register<MavenPublication>("java") {
            groupId = dependenciesGroup
            artifactId = dependenciesName
            version = dependenciesVersion

            afterEvaluate {
                from(components["java"])
            }
        }
    }
    repositories {
        maven {
            name = "repositoryLocalRepo"
            url = uri("${rootProject.projectDir}/repo")
        }
    }
}