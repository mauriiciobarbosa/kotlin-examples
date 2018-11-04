import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale
import java.text.NumberFormat

fun main(args: Array<String>) {
    val value: Double = 150.toDouble()
    println(value.formatMoney())
}

fun Double.formatMoney(locale: Locale = Locale("pt", "BR")) : String {
    val numberFormater = NumberFormat.getCurrencyInstance(locale)
    var result = "R\$0,00"

    if (' ' !in result) {
        println("entrou")
        val result2 = result.substring(0..1) + " " + result.substring(2..result.lastIndex)
        println(result2)
        result = result.substring(0..1).padEnd(2) + result.substring(2..result.lastIndex)
    }

    return result
}