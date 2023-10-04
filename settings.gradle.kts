pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "videogames"
include(":app")
include(":data")
include(":utilidades")
include(":funcionalidades")
include(":funcionalidades:inicio")
include(":funcionalidades:listado")
include(":funcionalidades:detalles")
include(":funcionalidades:favoritos")



