package com.convention

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension


internal fun Project.configureKotlinMultiplatformLibrary(extension: KotlinMultiplatformExtension) {
    extension.apply {
        applyProjectHierarchyTemplate()
    }
}