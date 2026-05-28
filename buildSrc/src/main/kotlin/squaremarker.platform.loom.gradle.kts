plugins {
    id("squaremarker.platform")
    id("xyz.jpenilla.quiet-fabric-loom")
    id("com.gradleup.shadow")
}

val minecraftVersion: String by rootProject

val projectImpl: Configuration by configurations.creating
configurations.implementation {
    extendsFrom(projectImpl)
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    projectImpl(project(":squaremarker-common"))
}

val markerExt = extensions.getByType<SquareMarkerPlatformExtension>()
markerExt.productionJar = tasks.shadowJar.flatMap { it.archiveFile }

tasks {
    shadowJar {
        configurations = listOf(projectImpl)
        dependencies {
            exclude {
                it.moduleGroup == "org.incendo"
            }
        }
        archiveFileName.set("${project.name}-mc$minecraftVersion-${project.version}.jar")
    }
}
