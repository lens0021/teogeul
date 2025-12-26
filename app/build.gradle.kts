plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.hilt)
}

android {
    namespace = "io.github.lens0021.teogeul"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.lens0021.teogeul"
        minSdk = 26
        targetSdk = 34

        val versionString = "0.4.2" // x-release-please-version
        versionName = versionString

        // Auto-calculate versionCode from versionName (e.g., 1.2.3 -> 10203)
        val parts = versionString.split(".")
        versionCode = parts[0].toInt() * 10000 + parts[1].toInt() * 100 + parts[2].toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.txt")
            // Use debug signing config for development/testing releases
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    applicationVariants.all {
        outputs.all {
            val outputImpl = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            val buildType = buildType.name
            val version = versionName
            outputImpl.outputFileName = "teogeul-$buildType-$version.apk"
        }
    }

    lint {
        checkAllWarnings = true
        disable += setOf("MissingTranslation", "ObsoleteLintCustomCheck")
        error += setOf("MissingPrefix", "StringFormatInvalid")
    }
}

repositories {
    google()
    mavenCentral()
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
    ksp(libs.hilt.compiler)
    debugImplementation(libs.compose.ui.tooling)
}
