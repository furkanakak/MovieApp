plugins {
    id(Plugins.kotlinAndroid) version PluginVersion.kotlinGradlePlugin
    id(Plugins.libraryAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltAndroidPlugin)
    id(Plugins.navigationSafeargs)
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
    buildFeatures {
        viewBinding = true
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

    // Retrofit dependencies
    implementation (Dependencies.retrofit)
    implementation (Dependencies.retrofitGsonConverter)

    // OkHttp dependencies
    implementation (Dependencies.okhttp)
    implementation (Dependencies.okhttpLoggingInterceptor)

    // Glide dependencies
    implementation (Dependencies.glide)
    annotationProcessor (Dependencies.glideCompiler)


    // Navigation dependencies
    implementation (Dependencies.navigationFragmentKtx)
    implementation (Dependencies.navigationUiKtx)


    // Room dependencies
    implementation (Dependencies.roomKtx)
    kapt (Dependencies.roomCompiler)
    androidTestImplementation (Dependencies.roomTesting)


    //Coroutines
    implementation (Dependencies.coroutinesAndroid)
    implementation (Dependencies.coroutinesCore)


}