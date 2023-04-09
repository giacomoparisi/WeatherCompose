plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.giacomoparisi.core"
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
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidX.Compose.version
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    /* --- modules --- */
    implementation(project(":entities"))
    implementation(project(":domain"))
    implementation(project(":data"))

    /* --- kotlin --- */
    implementation(KotlinX.Coroutines.core)
    implementation(KotlinX.Coroutines.android)

    /* --- hilt --- */
    implementation(Google.Hilt.android)
    kapt(Google.Hilt.compiler)
    kapt(AndroidX.Hilt.compiler)

    /* --- compose --- */
    implementation(AndroidX.Compose.ui)
    implementation(AndroidX.Compose.uiText)
    implementation(AndroidX.Compose.uiTooling)
    implementation(AndroidX.Compose.uiPreview)
    implementation(AndroidX.Compose.foundation)
    implementation(AndroidX.Compose.material3)
    implementation(AndroidX.Compose.animation)
    implementation(AndroidX.Lifecycle.viewModelCompose)
    implementation(AndroidX.Activity.compose)

    /* --- lottie --- */
    implementation(AirBnb.lottieCompose)

}