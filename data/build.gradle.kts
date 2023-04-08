plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.giacomoparisi.data"
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
        isCoreLibraryDesugaringEnabled = true
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
    implementation(project(":domain"))

    /* --- desugar --- */
    coreLibraryDesugaring(Android.desugar)

    /* --- kotlin --- */
    implementation(KotlinX.Coroutines.core)
    implementation(KotlinX.Coroutines.android)

    /* --- hilt --- */
    implementation(Google.Hilt.android)
    kapt(Google.Hilt.compiler)

    /* --- retrofit --- */
    implementation(Squareup.Retrofit2.retrofit)
    implementation(Squareup.Retrofit2.Converter.moshi)
    implementation(Squareup.OkHttp3.loggingInterceptor)
    implementation(Squareup.Moshi.kotlin)

    /* --- room --- */
    implementation(AndroidX.Room.runtime)
    implementation(AndroidX.Room.ktx)
    kapt(AndroidX.Room.compiler)
    androidTestImplementation(AndroidX.Room.testing)
}