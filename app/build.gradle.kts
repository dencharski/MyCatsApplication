import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "2.0.21"

    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.kotlin.kapt)

}

android {
    namespace = "com.example.mycatsapplication"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.mycatsapplication"
        minSdk = 29
        targetSdk = 34
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    //android.buildFeatures.

    buildTypes.forEach { buildType ->

        buildType.buildConfigField(
            "String",
            "CAT_API_KEY",
            project.property("CAT_API_KEY") as String
        )
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.collection.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //hilt
    implementation(libs.hilt.android)
    annotationProcessor(libs.hilt.compiler)


    implementation (libs.hilt.android)
    kapt (libs.hilt.android.compiler)
    kapt (libs.androidx.hilt.hilt.compiler)
    implementation (libs.androidx.activity.ktx)
    //glide
    implementation(libs.glide)
    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)
    //coroutines
    implementation(libs.kotlinx.coroutines.android)
    //fragments
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.navigation.dynamic.features.fragment)

    // Jetpack Compose integration
    implementation(libs.androidx.navigation.compose)

    //navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)


}