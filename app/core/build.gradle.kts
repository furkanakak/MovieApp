plugins {
    id(Plugins.kotlinAndroid) version PluginVersion.kotlinGradlePlugin
    id(Plugins.libraryAndroid)
}

android {
    namespace = Configs.namespaceCore
    compileSdk = Configs.compileSdk

    defaultConfig {
        minSdk = Configs.minSdk
        testInstrumentationRunner = Configs.testInstrumentationRunner
        consumerProguardFiles(Configs.consumerProguardFiles)
    }

    buildTypes {
        release {
            isMinifyEnabled = Configs.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(Configs.proguardFileName),
                Configs.proguardRules
            )
        }
    }
    compileOptions {
        sourceCompatibility = Configs.sourceCompatibility
        targetCompatibility = Configs.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Configs.jvmTarget
    }
}

dependencies {
    implementation (Dependencies.coreKtx)
    implementation (Dependencies.appCompat)
    implementation (Dependencies.material)
    implementation (Dependencies.activityKtx)
    implementation (Dependencies.constraintLayout)
    testImplementation (Dependencies.junit)
    androidTestImplementation (Dependencies.androidJunit)
    androidTestImplementation (Dependencies.espressoCore)
}