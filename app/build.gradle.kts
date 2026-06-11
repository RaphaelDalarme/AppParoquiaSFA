plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.appparoquiasfa"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.appparoquiasfa"
        minSdk = 24
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
}

dependencies {
    // Bibliotecas essenciais de interface (O erro acontece se estas aqui sumirem)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Testes Unitários
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // --- ROOM DATABASE ---
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    // --- CORREÇÃO DE METADADOS DO KOTLIN ---
    implementation("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.9.0")
    annotationProcessor("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.9.0")
}

configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.9.0")
    }
}