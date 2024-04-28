

buildscript {
    dependencies {
        classpath (Plugins.hiltGradlePlugin)
        classpath (Plugins.navigationNavigationSafeArgs)
    }
}


plugins {
    id(Plugins.androidApplication) version PluginVersion.androidGradlePlugin apply false
    id(Plugins.kotlinAndroid) version PluginVersion.kotlinGradlePlugin apply false
    id(Plugins.libraryAndroid) version PluginVersion.androidGradlePlugin apply false
    id(Plugins.navigationSafeArgsPlugin) version PluginVersion.navigationSafeArgs  apply false
}

