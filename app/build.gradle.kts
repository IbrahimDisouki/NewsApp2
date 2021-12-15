plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.mdi.newsapp"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + "-Xjvm-default=all" // Only required for 2.x.
    }

    buildFeatures {
        viewBinding = true
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

}

dependencies {
    testImplementation("org.orbit-mvi:orbit-test:4.3.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.junit.platform:junit-platform-console:1.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("org.mockito:mockito-inline:4.0.0")
    testImplementation("com.appmattus.fixture:fixture:1.2.0")

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    implementation("com.google.android.material:material:1.4.0")

    implementation("com.google.dagger:hilt-android:2.40.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    implementation("org.orbit-mvi:orbit-core:4.3.0")
    implementation("org.orbit-mvi:orbit-viewmodel:4.3.0")

    implementation("io.ktor:ktor-client-serialization:1.6.7")
    implementation("io.ktor:ktor-client-logging-jvm:1.6.7")
    implementation("io.ktor:ktor-client-okhttp:1.6.7")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")

    implementation("io.coil-kt:coil:1.4.0")
}