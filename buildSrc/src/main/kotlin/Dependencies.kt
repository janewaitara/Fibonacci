object Versions {

    //Version codes for all the libraries
    const val android = "7.4.1"
    const val kotlin = "1.8.10"
    const val ktx = "1.9.0"

    //Text libraries
    const val junit4 = "4.13.2"
    const val junit = "1.1.5"
    const val espresso = "3.5.1"

    //Compose
    const val composeUi = "1.3.3"
    const val composeMaterial3 = "1.0.1"
    const val constraintLayoutCompose = "1.0.0-beta02"
    const val activityCompose = "1.6.1"
    const val composeCompiler = "1.4.2"

    //Lifecycle
    const val lifecycle = "2.6.0"
}
object BuildPlugins {
    //All the build plugins are added here
    const val androidLibrary = "com.android.library"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
}
object Libraries {
    //Any Library is added here
   const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"

    //Compose
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeUi}"
    const val composeTooling = "androidx.compose.ui:ui-tooling-preview:${Versions.composeUi}"
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"

    //Lifecycle
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
}
object TestLibraries {
    //any test library is added here
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val composeJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.composeUi}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.composeUi}"
    const val composeManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeUi}"
}
object AndroidSdk {
    const val minSdkVersion = 24
    const val compileSdkVersion = 33
    const val targetSdkVersion = compileSdkVersion
    const val versionCode = 1
    const val versionName = "1.0"
}