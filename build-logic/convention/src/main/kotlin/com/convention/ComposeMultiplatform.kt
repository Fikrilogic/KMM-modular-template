package com.convention

import org.gradle.api.Project
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun KotlinMultiplatformExtension.configureCompose(extensions: ComposeExtension) =
    extensions.apply {
        val deps = this.dependencies
        sourceSets.apply {
            commonMain {
                dependencies {
                    implementation(deps.runtime)
                    implementation(deps.foundation)
                    implementation(deps.material3)
                    implementation(deps.materialIconsExtended)
                    implementation(deps.ui)
                    implementation(deps.components.resources)
                    implementation(deps.components.uiToolingPreview)
                }
            }
            androidMain {
                dependencies {
                    implementation(deps.preview)
                }
            }
        }
    }