import com.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.add
import org.gradle.kotlin.dsl.dependencies

class MultiplatformKoinPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target){
        with(pluginManager){
            apply(libs.findPlugin("ksp").get().get().pluginId)
        }

        dependencies {
            add("commonMainImplementation", libs.findLibrary("koin-core").get())
            add("commonMainImplementation", libs.findLibrary("koin-compose").get())
            add("commonMainImplementation", libs.findLibrary("koin-compose-viewmodel").get())
            add("commonMainImplementation", libs.findLibrary("koin-compose-viewmodel-navigation").get())
            add("commonTestImplementation", libs.findLibrary("koin-test").get())
        }
    }
}