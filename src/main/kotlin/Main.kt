import org.calc.Fracao
import kotlin.system.exitProcess

fun main() {
    while (true) {
        val entrada = readln().replace("\\s".toRegex(), "")
        if (entrada.trim() == "s")
            exitProcess(0)

        val args = entrada.split("(?=[+\\-*:])|(?<=[+\\-*:])".toRegex())
        println(args)
        try {
            val op = args[1]
            val f1 = fracao(args[0])
            val f2 = fracao(args[2])

            val resultado = when (op) {
                "+" -> f1 + f2
                "-" -> f1 - f2
                "*" -> f1 * f2
                ":" -> f1 / f2
                else -> null
            }

            println("$f1 $op $f2 = $resultado")
        } catch (e: Exception) {
            val m = e.message
            println("entrada inválida: $m")
        }
    }
}

private fun fracao(texto: String): Fracao {
    val vs = texto.split('/').map { t -> t.toInt() }
    return if (vs.size > 1) Fracao(vs[0], vs[1]) else Fracao(vs[0])
}
