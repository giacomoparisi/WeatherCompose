plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.giacomoparisi.domain"
    compileSdk = ProjectSettings.compileSdkVersion

    defaultConfig {
        minSdk = ProjectSettings.minSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    /* --- modules --- */
    implementation(project(":entities"))

    /* --- kotlin --- */
    implementation(KotlinX.Coroutines.core)
    implementation(KotlinX.Coroutines.android)

    /* --- hilt --- */
    implementation(Google.Hilt.android)
    kapt(Google.Hilt.compiler)

}