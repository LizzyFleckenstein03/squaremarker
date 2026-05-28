plugins {
    id("squaremarker.platform.loom")
}

val fabricApiVersion: String by rootProject
val fabricLoaderVersion: String by rootProject
val cloudMinecraftModdedVersion: String by rootProject
val adventureFabricVersion: String by rootProject

dependencies {
    implementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    implementation("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion")

    // We don't include() these since squaremap already does and we depend on it
    implementation("org.incendo:cloud-fabric:$cloudMinecraftModdedVersion")
    implementation("net.kyori:adventure-platform-fabric:$adventureFabricVersion")
}

squareMarker {
    modInfoFilePath = "fabric.mod.json"
}
