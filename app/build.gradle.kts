@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.ktlintPlugin)
    id(BuildPlugins.hiltPlugin)
    id("kotlin-kapt")
    kotlin("kapt")
}

android {
    namespace = "com.mumbicodes.fibonacci"
    compileSdk = AndroidSdk.compileSdkVersion

    defaultConfig {
        applicationId = "com.mumbicodes.fibonacci"
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Libraries.ktxCore)

    // Lifecycle
    implementation(Libraries.lifecycle)
    implementation(Libraries.lifecycleViewModel)

    // Compose
    implementation(Libraries.composeActivity)
    implementation(Libraries.composeUi)
    implementation(Libraries.composeTooling)
    implementation(Libraries.composeMaterial3)

    // DI - Hilt
    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltCompilerAndroid)
    kapt(Libraries.hiltCompiler)
    implementation(Libraries.hiltNavigation)

    // Room
    implementation(Libraries.roomRuntime)
    kapt(Libraries.roomCompiler)
    implementation(Libraries.roomKtx)

    // Coroutines
    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesAndroid)

    // Navigation
    implementation(Libraries.navigationCompose)

    // Moshi
    implementation(Libraries.moshi)
    implementation(Libraries.moshiConverter)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.junit)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.composeJunit4)
    debugImplementation(TestLibraries.composeTooling)
    debugImplementation(TestLibraries.composeManifest)
}
