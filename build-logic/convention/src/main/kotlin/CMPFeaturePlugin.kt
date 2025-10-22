import com.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CMPFeaturePlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.findPlugin("kmm-library-convention").get().get().pluginId)
                apply(libs.findPlugin("koin-multiplatform-convention").get().get().pluginId)
                apply(libs.findPlugin("detekt-convention").get().get().pluginId)
            }

            dependencies{
                add("commonMainImplementation", project(":core:ui"))
                add("commonMainImplementation", project(":core-base:designsystem"))
                add("commonMainImplementation", project(":core:data"))

            }
        }
    }
}