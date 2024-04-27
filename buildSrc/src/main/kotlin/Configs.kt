import org.gradle.api.JavaVersion

object Configs{
   val namespace = "com.furkan.movieapp"
   val compileSdk = 34
   val applicationId = "com.furkan.movieapp"
   val minSdk = 24
   val targetSdk = 34
   val versionCode = 1
   val versionName = "1.0"
   val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
   val sourceCompatibility = JavaVersion.VERSION_1_8
   val targetCompatibility = JavaVersion.VERSION_1_8
   val jvmTarget = "1.8"
   val isMinifyEnabled = false
   val proguardFileName = "proguard-android-optimize.txt"
   val proguardRules =  "proguard-rules.pro"
}