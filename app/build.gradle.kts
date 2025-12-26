plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
    alias(libs.plugins.ktlint)
    alias(libs.plugins.hilt)
}

android {
    compileSdk = 34
    buildToolsVersion = "34.0.0"
    namespace = "io.github.lens0021.teogeul"

    defaultConfig {
        applicationId = "io.github.lens0021.teogeul"
        minSdk = 26
        targetSdk = 34
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.txt")
        }
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    lint {
        // 기본 설정
        checkAllWarnings = true
        abortOnError = false

        // 리포트 생성
        htmlReport = true
        xmlReport = true

        // 비활성화할 규칙들
        disable += setOf(
            "MissingTranslation",
            "ObsoleteLintCustomCheck"  // Compose 린트 호환성 경고 무시
        )

        // 경고 대신 에러로 처리할 중요 규칙들
        error += setOf(
            "MissingPrefix",
            "StringFormatInvalid"
        )
    }
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.google.com")
    }
}

configurations.configureEach {
    resolutionStrategy.eachDependency {
        if (requested.group == "com.squareup" && requested.name == "javapoet") {
            useVersion(libs.versions.javapoet.get())
        }
    }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.coroutines.android)
    testImplementation(libs.junit)

    // Compose BOM
    val composeBom = platform(libs.compose.bom)
    implementation(composeBom)

    // Compose
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    implementation(libs.compose.material.icons)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.activity.compose)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.compose)
    implementation(libs.datastore.preferences)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kapt(libs.javapoet)
    debugImplementation(libs.compose.ui.tooling)
}
