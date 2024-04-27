buildscript {
    dependencies {
        classpath (Plugins.hiltGradlePlugin)
    }
}


plugins {
    id(Plugins.androidApplication) version PluginVersion.androidGradlePlugin apply false
    id(Plugins.kotlinAndroid) version PluginVersion.kotlinGradlePlugin apply false
    id(Plugins.libraryAndroid) version PluginVersion.androidGradlePlugin apply false
}

