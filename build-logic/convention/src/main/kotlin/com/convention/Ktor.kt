package com.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKtor(extension: KotlinMultiplatformExtension) = extension.apply {


    sourceSets.apply {
        commonMain.dependencies {
            implementation(libs.findLibrary("ktorfit-lib"))
            implementation(libs.findLibrary("ktorfit-converters-flow"))
            implementation(libs.findLibrary("ktorfit-converters-response"))
            implementation(libs.findLibrary("ktorfit-converters-call"))

            implementation(libs.findLibrary("ktor-client-core").get())
            implementation(libs.findLibrary("ktor-client-cio").get())
            implementation(libs.findLibrary("ktor-client-logging").get())
            implementation(libs.findLibrary("ktor-client-serialization").get())
            implementation(libs.findLibrary("ktor-serialization-kotlinx-json").get())
            implementation(libs.findLibrary("ktor-client-content-negotiation").get())
        }

        androidMain.dependencies {
            implementation(libs.findLibrary("ktor-client-android").get())
        }

        iosMain.dependencies {
            implementation(libs.findLibrary("ktor-client-darwin").get())
        }
    }
}