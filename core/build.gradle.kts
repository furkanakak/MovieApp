plugins {
    id(Plugins.kotlinAndroid) version PluginVersion.kotlinGradlePlugin
    id(Plugins.libraryAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltAndroidPlugin)
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

    // Hilt dependencies
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
    androidTestImplementation(Dependencies.hiltAndroidTesting)
    kaptAndroidTest(Dependencies.hiltCompiler)
    testImplementation(Dependencies.hiltAndroidTesting)
    kaptTest(Dependencies.hiltCompiler)


    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")



}