import org.calc.Fracao
import kotlin.system.exitProcess

fun main() {
    while (true) {
        val entrada = readln()
        if (entrada.trim() == "s")
            exitProcess(0)

        val args = entrada.split("""\s+""".toRegex())
        try {
            valida(args)
            val op = args[1]

            val f1 = fracao(*ints(args[0]))
            val f2 = fracao(*ints(args[2]))

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

fun valida(args: List<String>) {
    if (args.any { a -> a.replace("[0-9]".toRegex(), "").length > 1 })
        throw IllegalArgumentException("separe as operações")
}

private fun ints(texto: String) = texto.split('/').map { t -> t.toInt() }.toIntArray()

private fun fracao(vararg vs: Int) = if (vs.size > 1) Fracao(vs[0], vs[1]) else Fracao(vs[0])
