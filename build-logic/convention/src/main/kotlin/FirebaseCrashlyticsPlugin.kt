import com.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class FirebaseCrashlyticsPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target){
        with(pluginManager){
            apply(libs.findPlugin("google-gms-services").get().get().pluginId)
            apply(libs.findPlugin("firebase-crashlytics").get().get().pluginId)
        }

        dependencies{
//            add("commonMainImplementation", libs.findLibrary("firebase-crashlytics-ndk").get())
//            add("commonMainImplementation", libs.findLibrary("firebase-analytics").get())
            add("commonMainImplementation", libs.findLibrary("firebase-bom").get())
        }
    }
}