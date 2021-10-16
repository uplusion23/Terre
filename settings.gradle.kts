rootProject.name = "Terre"

listOf("proxy", "image", "k8s-server-finder", "portals", "tshock-users", "test").forEach {
  include(it)
  project(":$it").name = "terre-$it"
}

pluginManagement {
  repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
  }
}
