package co.videogames.core_ui.ayudas

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

object General {

    fun cambiarFormatoDeFecha(dateString: String): String {
        val fechaOriginal = SimpleDateFormat("yyyy-MM-dd")
        val fechaSalida = SimpleDateFormat("dd/MM/yyyy")
        val date: Date? = try {
            fechaOriginal.parse(dateString)
        } catch (e: ParseException) {
            return dateString
        }
        return fechaSalida.format(date)
    }

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