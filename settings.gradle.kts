rootProject.name = "CountryQuizz"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":core-base:designsystem")
include(":core-base:database")
include(":core-base:datastore")
include(":core-base:network")
include(":core:domain")
include(":core:model")
include(":core:database")
include(":core:data")
include(":core:datastore")
include(":core:network")
include(":core:ui")
include(":core:common")
include(":feature:auth")
include(":feature:dashboard")
include(":core:designsystem")
include(":feature:navigation")
