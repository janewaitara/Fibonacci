plugins {
    id(BuildPlugins.androidLibrary) version Versions.android apply false
    id(BuildPlugins.androidApplication) version Versions.android apply false
    id(BuildPlugins.kotlinAndroid) version Versions.kotlin apply false
    id(BuildPlugins.ktlintPlugin) version Versions.ktlint
}

allprojects {

    apply(plugin = BuildPlugins.ktlintPlugin)
    ktlint {
        android.set(false)
        verbose.set(false)
        filter {
            exclude { element -> element.file.path.contains("generated/") }
        }
        disabledRules.set(setOf("no-wildcard-imports"))
    }
}
