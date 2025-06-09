package com.convention

import androidx.room.gradle.RoomExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureRoom(extension: RoomExtension) = extension.apply {
    schemaDirectory("$projectDir/schemas")

    dependencies {
        "implementation"(libs.findLibrary("room-ktx").get())

        listOf(
            "kspAndroid",
            "kspIosX64",
            "kspIosArm64",
            "kspIosSimulatorArm64",
            "kspDesktop",
        ).forEach {
            add(it, libs.findLibrary("room-compiler").get())
            add(it, libs.findLibrary("room-ktx").get())
        }
    }
}