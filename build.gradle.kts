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

// JSON validation task
tasks.register("validateJson") {
    description = "Validate JSON files syntax"
    group = "verification"

    doLast {
        val jsonFiles = fileTree(projectDir) {
            include("**/*.json")
            exclude("**/build/**", "**/.gradle/**", "**/.git/**", "**/.rumdl_cache/**", "**/.claude/**")
        }

        var hasErrors = false
        jsonFiles.forEach { file ->
            try {
                // Simple JSON validation using Groovy's JsonSlurper
                groovy.json.JsonSlurper().parse(file)
                println("✓ ${file.relativeTo(projectDir).path}")
            } catch (e: Exception) {
                hasErrors = true
                println("✗ ${file.relativeTo(projectDir).path}: ${e.message}")
            }
        }

        if (hasErrors) {
            throw GradleException("JSON validation failed. See errors above.")
        }
    }
}

// JSON formatting check task
tasks.register("checkJsonFormat") {
    description = "Check JSON files formatting (2-space indent, final newline)"
    group = "verification"

    doLast {
        val jsonFiles = fileTree(projectDir) {
            include("**/*.json")
            exclude("**/build/**", "**/.gradle/**", "**/.git/**", "**/.rumdl_cache/**", "**/.claude/**")
        }

        var hasErrors = false
        jsonFiles.forEach { file ->
            val content = file.readText()
            val issues = mutableListOf<String>()

            // Check final newline
            if (!content.endsWith("\n")) {
                issues.add("missing final newline")
            }

            // Check trailing whitespace
            if (content.lines().any { it.endsWith(" ") || it.endsWith("\t") }) {
                issues.add("has trailing whitespace")
            }

            // Check indent (no tabs for JSON)
            val hasTabIndent = content.lines().any { it.startsWith("\t") }

            if (hasTabIndent) {
                issues.add("uses tabs instead of spaces")
            }

            if (issues.isNotEmpty()) {
                hasErrors = true
                println("✗ ${file.relativeTo(projectDir).path}: ${issues.joinToString(", ")}")
            } else {
                println("✓ ${file.relativeTo(projectDir).path}")
            }
        }

        if (hasErrors) {
            throw GradleException("JSON formatting check failed. See errors above.")
        }
    }
}

// Aggregate check task
tasks.register("lintJson") {
    description = "Run all JSON checks (validation + formatting)"
    group = "verification"
    dependsOn("validateJson", "checkJsonFormat")
}
