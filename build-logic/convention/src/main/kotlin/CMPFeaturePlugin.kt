import com.android.build.gradle.LibraryExtension
import com.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.compose.compose
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class CMPFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.findPlugin("androidLibrary").get().get().pluginId)
                apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
                apply(libs.findPlugin("detekt-convention").get().get().pluginId)
                apply(libs.findPlugin("kotlin-serialization").get().get().pluginId)
//                apply("com.convention.composeMultiplatform")
            }
            this.extensions.configure<KotlinMultiplatformExtension>(::configureApplication)

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
                add("commonMainImplementation", project(":core:ui"))
                add("commonMainImplementation", project(":core-base:designsystem"))
                add("commonMainImplementation", project(":core:designsystem"))
                add("commonMainImplementation", project(":core:data"))

                add("commonMainImplementation", libs.findLibrary("voyager-navigator").get().get())
                add("commonMainImplementation", libs.findLibrary("voyager-screenmodel").get().get())
                add("commonMainImplementation", libs.findLibrary("voyager-bottomsheet").get().get())
                add(
                    "commonMainImplementation",
                    libs.findLibrary("voyager-tabnavigator").get().get()
                )
                add("commonMainImplementation", libs.findLibrary("voyager-transitions").get().get())
                add("commonMainImplementation", libs.findLibrary("voyager-koin").get().get())

                add("commonMainImplementation", libs.findLibrary("coil-compose").get().get())
//                add("commonMainImplementation", libs.findLibrary("coil-network").get().get())
                add("commonMainImplementation", libs.findLibrary("coil-svg").get().get())

            }
        }
    }
}