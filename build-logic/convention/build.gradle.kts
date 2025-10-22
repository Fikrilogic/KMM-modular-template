import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins{
    `kotlin-dsl`
}

group = "com.convention.buildlogic"
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies{
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradleplugin)
    compileOnly(libs.detekt.gradlePlugin)
    compileOnly(libs.firebase.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}

gradlePlugin{
    plugins{
        register("kotlinMultiplatformApplication"){
            id = "com.convention.kotlinMultiplatformApplication"
            implementationClass = "KotlinMultiplatformApplicationPlugin"
        }
        register("kotlinMultiplatformLibrary"){
            id = "com.convention.kotlinMultiplatformLibraryPlugin"
            implementationClass = "KotlinMultiplatformLibraryPlugin"
        }

        register("composeMultiplatform"){
            id = "com.convention.composeMultiplatform"
            implementationClass = "ComposeMultiplatformPlugin"
        }

        register("multiplatformKoinPlugin"){
            id = "com.convention.multiplatformKoinPlugin"
            implementationClass = "MultiplatformKoinPlugin"
        }

        register("DetektPlugin"){
            id = "com.convention.detektPlugin"
            implementationClass = "DetektPlugin"
        }

        register("FirebaseCrashlyticsPlugin"){
            id = "com.convention.firebaseCrashlytics"
            implementationClass = "FirebaseCrashlyticsPlugin"
        }

        register("RoomMultiplatformPlugin"){
            id = "com.convention.roomMultiplatform"
            implementationClass = "RoomMultiplatformPlugin"
        }

        register("KtorMultiplatformPlugin"){
            id = "com.convention.ktorMultiplatform"
            implementationClass = "KtorMultiplatformPlugin"
        }

        register("cmpFeature"){
            id = "com.convention.cmpFeature"
            implementationClass = "CMPFeaturePlugin"
        }
    }
}

