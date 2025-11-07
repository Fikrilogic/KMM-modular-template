import org.gradle.kotlin.dsl.project

plugins {
    alias(libs.plugins.cmp.feature.convention)
    alias(libs.plugins.compose.multiplatform.convention)
}

kotlin {

    // Target declarations - add or remove as needed below. These define
    // which platforms this KMP module supports.
    // See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
    android {
        namespace = "feature.quiz"
    }

    // Source set declarations.
    // Declaring a target automatically creates a source set with the same name. By default, the
    // Kotlin Gradle Plugin creates additional source sets that depend on each other, since it is
    // common to share sources between related targets.
    // See: https://kotlinlang.org/docs/multiplatform-hierarchy.html
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                // Add KMP dependencies here
                implementation(project(":feature:navigation"))
            }
        }

        androidMain {
            dependencies {
                // Add Android-specific dependencies here. Note that this source set depends on
                // commonMain by default and will correctly pull the Android artifacts of any KMP
                // dependencies declared in commonMain.
            }
        }
    }

}

compose {
    resources {
        packageOfResClass = "org.countryquizz.feature.quiz.generated.resources"
        publicResClass = true
        generateResClass = always
    }
}