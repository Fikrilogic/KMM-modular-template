import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project):Unit = with(target){
        with(pluginManager){
            apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("androidApplication").get().get().pluginId)
            apply(libs.findPlugin("detekt-convention").get().get().pluginId)
            apply(libs.findPlugin("kotlin-serialization").get().get().pluginId)
        }
        this.extensions.configure<KotlinMultiplatformExtension>(::configureApplication)

        this.extensions.configure<ApplicationExtension>(::configureKotlinAndroid)

        dependencies {
            add("commonTestImplementation", libs.findLibrary("kotlin.test").get())
            add("commonMainImplementation", libs.findLibrary("napier").get())
        }
    }
}