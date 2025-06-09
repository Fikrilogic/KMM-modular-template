import com.convention.configureDetekt
import com.convention.libs
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class DetektPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target){
        with(pluginManager){
            apply(libs.findPlugin("detekt").get().get().pluginId)
        }
        this.extensions.configure<DetektExtension>(::configureDetekt)
    }
}