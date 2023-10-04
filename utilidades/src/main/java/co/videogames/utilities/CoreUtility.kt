package co.videogames.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object CoreUtility {
    fun estaConectadoAInternet(context: Context): Boolean {
        val administradorConectividad = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capacidadesRed = administradorConectividad.activeNetwork ?: return false
        val red = administradorConectividad.getNetworkCapabilities(capacidadesRed) ?: return false
        val resultado = when {
            red.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            red.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            red.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
        return resultado
    }
}