plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.flash.retrofitapp"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.flash.retrofitapp"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

        // Retrofit
        implementation("com.squareup.retrofit2:retrofit:3.0.0")

        // Converter (Gson example for JSON serialization/deserialization)
        implementation("com.squareup.retrofit2:converter-gson:3.0.0")

        // OkHttp logging interceptor (optional, for debugging network requests)
        implementation("com.squareup.okhttp3:logging-interceptor:5.3.2")
        implementation("com.squareup.okhttp3:okhttp:5.3.2")

        // Kotlin Coroutines (highly recommended for asynchronous operations with Retrofit in Kotlin)
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2") // Use the latest version
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2") // Use the latest version

        implementation("de.hdodenhof:circleimageview:3.1.0")

}