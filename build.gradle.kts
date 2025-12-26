import com.diffplug.spotless.extra.wtp.EclipseWtpFormatterStep

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
    alias(libs.plugins.spotless)
}

val jsonFileTree = fileTree(projectDir) {
    include("**/*.json")
    exclude("**/build/**", "**/.gradle/**", "**/.git/**", "**/.rumdl_cache/**", "**/.claude/**")
}

tasks.register("validateJson") {
    group = "verification"
    doLast {
        var hasErrors = false
        jsonFileTree.forEach { file ->
            try {
                groovy.json.JsonSlurper().parse(file)
                println("✓ ${file.relativeTo(projectDir).path}")
            } catch (e: Exception) {
                hasErrors = true
                println("✗ ${file.relativeTo(projectDir).path}: ${e.message}")
            }
        }
        if (hasErrors) throw GradleException("JSON validation failed")
    }
}

tasks.register("checkJsonFormat") {
    group = "verification"
    doLast {
        var hasErrors = false
        jsonFileTree.forEach { file ->
            val content = file.readText()
            val issues = mutableListOf<String>()

            if (!content.endsWith("\n")) issues.add("missing final newline")
            if (content.lines().any { it.endsWith(" ") || it.endsWith("\t") }) issues.add("trailing whitespace")
            if (content.lines().any { it.startsWith("\t") }) issues.add("uses tabs")

            if (issues.isNotEmpty()) {
                hasErrors = true
                println("✗ ${file.relativeTo(projectDir).path}: ${issues.joinToString(", ")}")
            } else {
                println("✓ ${file.relativeTo(projectDir).path}")
            }
        }
        if (hasErrors) throw GradleException("JSON formatting check failed")
    }
}

tasks.register("lintJson") {
    group = "verification"
    dependsOn("validateJson", "checkJsonFormat")
}

spotless {
    format("xml") {
        target("**/*.xml")
        targetExclude("**/build/**", "**/.gradle/**", "**/.git/**", "**/.rumdl_cache/**", "**/.claude/**")
        eclipseWtp(EclipseWtpFormatterStep.XML).configFile(".spotless-xml-style.prefs")
    }
}
