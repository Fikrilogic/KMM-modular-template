package com.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.plugin.cocoapods.CocoapodsExtension

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

//val Project.androidLibs
//    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("androidLibs")

