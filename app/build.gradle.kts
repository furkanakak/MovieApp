plugins {
    id(Plugins.androidApplication) version PluginVersion.androidGradlePlugin
    id(Plugins.kotlinAndroid) version PluginVersion.kotlinGradlePlugin
    id(Plugins.kotlinKapt)
    id(Plugins.hiltAndroidPlugin)
}

android {
    namespace = Configs.namespace
    compileSdk = Configs.compileSdk

    defaultConfig {
        applicationId = Configs.applicationId
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = Configs.testInstrumentationRunner
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

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }



}

dependencies {
    implementation(project(":core"))
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.activityKtx)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.junit)
    implementation(Dependencies.androidJunit)
    implementation(Dependencies.espressoCore)


    // Hilt dependencies
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
    androidTestImplementation(Dependencies.hiltAndroidTesting)
    kaptAndroidTest(Dependencies.hiltCompiler)
    testImplementation(Dependencies.hiltAndroidTesting)
    kaptTest(Dependencies.hiltCompiler)



}