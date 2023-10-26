package org.calc

import java.util.*

class Fracao(numerador: Int, denominador: Int = 1) {
    val denominador: Int
    val numerador: Int

    init {
        require(denominador != 0) { "Denominador não pode ser zero" }
        this.numerador = if (denominador < 0) -numerador else numerador
        this.denominador = if (denominador < 0) -denominador else denominador
    }

    operator fun plus(b: Fracao) =
        if (denominador == b.denominador) fracaoSimplificada(numerador + b.numerador, denominador)
        else somarComDenomiadorComum(b)

    private fun somarComDenomiadorComum(b: Fracao) =
        fracaoSimplificada(
            numerador * b.denominador + b.numerador * denominador,
            denominador * b.denominador
        )

    operator fun minus(b: Fracao) = plus(Fracao(-b.numerador, b.denominador))

    operator fun times(b: Fracao) = fracaoSimplificada(numerador * b.numerador, denominador * b.denominador)

    operator fun div(b: Fracao): Fracao {
        validaDiv(b)
        return times(Fracao(b.denominador, b.numerador))
    }

    private fun validaDiv(b: Fracao) {
        if (numerador == 0 && b.numerador == 0) {
            throw IllegalArgumentException("0/0 -> Resultado indefinido")
        }
        require(b.numerador != 0) { "Não é possível dividir por zero" }
    }

    private fun fracaoSimplificada(numerador: Int, denominador: Int): Fracao {
        val mdc = mdc(numerador, denominador)
        return Fracao(numerador / mdc, denominador / mdc)
    }

    override fun equals(other: Any?) =
        other is Fracao && numerador == other.numerador && denominador == other.denominador

    override fun hashCode() = Objects.hash(numerador, denominador)

    override fun toString() = if (denominador == 1) "$numerador" else "$numerador/$denominador"
}

tailrec fun mdc(a: Int, b: Int): Int {
    return if (b == 0) a else mdc(b, a % b)
}
