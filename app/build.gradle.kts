plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.giacomoparisi.weathercompose"
    compileSdk = ProjectSettings.compileSdkVersion

    defaultConfig {
        applicationId = "com.giacomoparisi.weathercompose"
        minSdk = ProjectSettings.minSdkVersion
        targetSdk = ProjectSettings.targetSdkVersion
        versionCode = ProjectSettings.versionCode
        versionName = ProjectSettings.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    /* --- android --- */
    implementation(AndroidX.Core.ktx)
    implementation(AndroidX.Lifecycle.viewModelKtx)
    implementation(AndroidX.Activity.compose)

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
    implementation(AndroidX.Compose.material)
    implementation(AndroidX.Compose.animation)
    implementation(AndroidX.Lifecycle.viewModelCompose)
    implementation(AndroidX.Activity.compose)

    /* --- navigation --- */
    implementation(AndroidX.Navigation.compose)
    implementation(Google.Accompanist.navigationAnimation)
    implementation(AndroidX.Hilt.navigationCompose)
}