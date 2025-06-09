import com.convention.applyProjectHierarchyTemplate
import com.convention.libs
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureApplication(
    extension: KotlinMultiplatformExtension
) = extension.apply {

    // targets
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    applyProjectHierarchyTemplate()

    //common dependencies
    sourceSets.apply {
        androidMain.dependencies {
            implementation(libs.findLibrary("androidx-activity-compose").get())
//            implementation(libs.findLibrary("ktor-okhttp").get())
            implementation(libs.findLibrary("kotlinx-coroutines-android").get())
        }

        iosMain.dependencies {
//            implementation(libs.findLibrary("ktor-darwin").get())
        }
        commonMain.dependencies {
            implementation(libs.findLibrary("androidx-lifecycle-viewmodel").get())
            implementation(libs.findLibrary("androidx-lifecycle-runtimeCompose").get())
            implementation(libs.findLibrary("kotlinx-serialization-core").get())
            implementation(libs.findLibrary("kotlinx-serialization-json").get())
//            implementation(libs.findLibrary("ktor-core").get())
//            implementation(libs.findLibrary("ktor-cio").get())
            implementation(libs.findLibrary("kotlinx-coroutines-core").get())

        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }


}