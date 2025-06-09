import androidx.room.gradle.RoomExtension
import com.convention.configureRoom
import com.convention.libs
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class RoomMultiplatformPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target){
        with(pluginManager) {
            apply(libs.findPlugin("ksp").get().get().pluginId)
            apply(libs.findPlugin("room").get().get().pluginId)
        }

        extensions.configure(KspExtension::class.java){
            arg("room.generateKotlin", "true")
        }

        extensions.configure(RoomExtension::class.java){
            configureRoom(this)
        }
    }
}