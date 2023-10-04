object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"}
}
object Modules {
    val CoreUi = ":core_ui"
    val data: String = ":data"
    val utilidades: String = ":utilidades"
    val detalles: String = ":funcionalidades:detalles"
    val listado: String = ":funcionalidades:listado"
    val inicio: String = ":funcionalidades:inicio"
    val favoritos: String = ":funcionalidades:favoritos"
}