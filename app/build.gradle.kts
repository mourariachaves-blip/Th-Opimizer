plugins { id("com.android.application"); id("org.jetbrains.kotlin.android") }
android {
    namespace = "com.th.optimizer"
    compileSdk = 34
    defaultConfig { applicationId = "com.th.optimizer"; minSdk = 29; targetSdk = 34; versionCode = 14; versionName = "5.0" }
    buildTypes { release { isMinifyEnabled = true } }
    compileOptions { sourceCompatibility = JavaVersion.VERSION_17; targetCompatibility = JavaVersion.VERSION_17 }
    kotlinOptions { jvmTarget = "17" }
}
