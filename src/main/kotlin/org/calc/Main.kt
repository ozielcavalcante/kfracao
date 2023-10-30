package org.calc;

import kotlin.system.exitProcess

class Main {
    fun fracao(texto: String): Fracao {
        val vs = texto.split('/').map { t -> t.toInt() }
        return if (vs.size > 1) Fracao(vs[0], vs[1]) else Fracao(vs[0])
    }
}

fun main() {
    val main = Main()
    while (true) {
        val entrada = readln().replace("\\s".toRegex(), "")
        if (entrada.trim() == "s")
            exitProcess(0)

        val args = entrada.split("(?=[-+*:])|(?<=[-+*:])".toRegex())
        try {
            val op = args[1]
            val f1 = main.fracao(args[0])
            val f2 = main.fracao(args[2])

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
