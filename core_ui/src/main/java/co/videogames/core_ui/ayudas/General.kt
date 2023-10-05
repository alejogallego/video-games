package co.videogames.core_ui.ayudas

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

}