plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
    id("kotlin-kapt")
}

val dependenciesGroup: String by extra
val dependenciesName: String by extra
val dependenciesVersion: String by extra
val androidCompileSdkVersion: String by extra
val androidMinSupportedVersion: String by extra

android {
    namespace = "com.gradle.basic.configuration.android"
    compileSdk = androidCompileSdkVersion.toInt()

    defaultConfig {
        minSdk = androidMinSupportedVersion.toInt()

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    publishing {
        singleVariant("release") {
            withJavadocJar()
            withSourcesJar()
        }
    }
}

dependencies {
    implementation(project(":statistic-interfaces"))
    implementation(project(":core-statistic"))

    val hiltVersion = "2.48"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")

    val commonVersion = "1.0.1"
    implementation("com.github.DroidLin.common:common-jvm:$commonVersion")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = dependenciesGroup
            artifactId = dependenciesName
            version = dependenciesVersion

            afterEvaluate {
                from(components["release"])
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