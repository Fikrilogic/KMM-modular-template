import com.android.build.gradle.LibraryExtension
import com.convention.configureKotlinMultiplatformLibrary
import com.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.findPlugin("androidLibrary").get().get().pluginId)
            apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("koin-multiplatform-convention").get().get().pluginId)
            apply(libs.findPlugin("detekt-convention").get().get().pluginId)
            apply(libs.findPlugin("kotlin-serialization").get().get().pluginId)
        }

        this.extensions.configure(KotlinMultiplatformExtension::class.java) {
            configureKotlinMultiplatformLibrary(this)
        }

        this.extensions.configure(LibraryExtension::class.java) {
            configureKotlinAndroid(this)

            defaultConfig.targetSdk =
                libs.findVersion("android-targetSdk").get().requiredVersion.toInt()
            resourcePrefix = path
                .split("""\W""".toRegex())
                .drop(1).distinct()
                .joinToString(separator = "_")
                .lowercase() + "_"
        }

        dependencies {
            add("commonTestImplementation", libs.findLibrary("kotlin.test").get())
            add("commonMainImplementation", libs.findLibrary("napier").get())
            add("commonTestImplementation", libs.findLibrary("okio-test").get())
            add("commonMainImplementation", libs.findLibrary("okio").get())

            add("commonMainImplementation", libs.findLibrary("kotlinx-serialization-core").get())
            add("commonMainImplementation", libs.findLibrary("kotlinx-serialization-json").get())
            add("commonMainImplementation", libs.findLibrary("kotlinx-coroutines-core").get())
        }
    }
}