import org.gradle.kotlin.dsl.invoke

plugins {
    alias(libs.plugins.kmp.application.convention)
    alias(libs.plugins.compose.multiplatform.convention)
    alias(libs.plugins.koin.multiplatform.convention)
    alias(libs.plugins.detekt.convention)
//    alias(libs.plugins.firebase.convention)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
        }
        commonMain.dependencies {

        }
        commonTest.dependencies {
        }
    }
}

android {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
    commonMainImplementation(project(":core-base:designsystem"))
}

