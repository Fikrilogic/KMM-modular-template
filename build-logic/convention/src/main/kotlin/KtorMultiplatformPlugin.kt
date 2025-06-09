import com.convention.configureKtor
import com.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KtorMultiplatformPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target){
        with(pluginManager){
            apply(libs.findPlugin("ksp").get().get().pluginId)
            apply(libs.findPlugin("ktorfit").get().get().pluginId)
            apply(libs.findPlugin("kotlin-serialization").get().get().pluginId)
        }

        extensions.configure(KotlinMultiplatformExtension::class.java){
            configureKtor(this)
        }
    }
}