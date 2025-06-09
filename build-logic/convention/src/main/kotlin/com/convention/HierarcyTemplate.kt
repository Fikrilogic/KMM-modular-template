package com.convention

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinHierarchyBuilder
import org.jetbrains.kotlin.gradle.plugin.KotlinHierarchyTemplate
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree


/*
* hierarchy template init
*
* */
@OptIn(ExperimentalKotlinGradlePluginApi::class)
private val hierarchyTemplate = KotlinHierarchyTemplate {
    withSourceSetTree(
        KotlinSourceSetTree.main,
        KotlinSourceSetTree.test,
    )

    common {
        withCompilations { true }

        groupNonAndroid()
        groupNonJsCommon()
        groupNonNative()
        groupNonJvmCommon()
        groupNative()
        groupJvmJsCommon()
        groupJsCommon()
        groupJvmCommon()

    }
}

/*
* extension for non android template
*
* */
@OptIn(ExperimentalKotlinGradlePluginApi::class)
private fun KotlinHierarchyBuilder.groupNonAndroid() {
    group("nonAndroid"){
        withJvm()
        groupJsCommon()
        groupNative()
    }
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
private fun KotlinHierarchyBuilder.groupJsCommon() {
    group("jsCommon"){
        withJs()
        withWasmJs()
    }
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
private fun KotlinHierarchyBuilder.groupNative() {
    group("native"){
        withNative()

        group("apple") {
            withApple()

            group("ios"){
                withIos()
            }

            group("macos"){
                withMacos()
            }
        }
    }
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
private fun KotlinHierarchyBuilder.groupNonJsCommon() {
    group("nonJsCommon"){
        groupNative()
        groupJvmCommon()
    }
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
private fun KotlinHierarchyBuilder.groupJvmCommon() {
    group("jvmCommon"){
        withAndroidTarget()
        withJvm()
    }
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
private fun KotlinHierarchyBuilder.groupJvmJsCommon() {
    group("jvmJsCommon"){
        groupJsCommon()
        withJvm()
    }
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
private fun KotlinHierarchyBuilder.groupNonNative() {
    group("nonNative"){
        groupJsCommon()
        groupJvmCommon()
    }
}


@OptIn(ExperimentalKotlinGradlePluginApi::class)
private fun KotlinHierarchyBuilder.groupNonJvmCommon() {
    group("nonJvmCommon"){
        groupJsCommon()
        groupNative()
    }
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
fun KotlinMultiplatformExtension.applyProjectHierarchyTemplate() {
    applyHierarchyTemplate(hierarchyTemplate)
}



