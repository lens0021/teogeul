// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.squareup:javapoet:${libs.versions.javapoet.get()}")
    }
    configurations.classpath {
        resolutionStrategy {
            force("com.squareup:javapoet:${libs.versions.javapoet.get()}")
        }
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.ktlint) apply false
}
