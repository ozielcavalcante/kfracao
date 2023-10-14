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

    operator fun unaryMinus() = Fracao(-numerador, denominador)

    operator fun minus(b: Fracao) = plus(-b)

    operator fun plus(b: Fracao) =
        if (denominador != b.denominador) somarComDenomiadorComum(b)
        else fracaoSimplificada(numerador + b.numerador, denominador)

    private fun somarComDenomiadorComum(b: Fracao): Fracao {
        val denominadorComum = denominador * b.denominador
        val novoNumerador = numerador * b.denominador + b.numerador * denominador
        return fracaoSimplificada(novoNumerador, denominadorComum)
    }

    private fun fracaoSimplificada(numerador: Int, denominador: Int): Fracao {
        val mdc = mdc(numerador, denominador)
        return Fracao(numerador / mdc, denominador / mdc)
    }

    private fun mdc(a: Int, b: Int): Int {
        return if (b == 0) a else mdc(b, a % b)
    }

    override fun equals(other: Any?) =
        other is Fracao && numerador == other.numerador && denominador == other.denominador

    override fun hashCode() = Objects.hash(numerador, denominador)

    override fun toString() = "$numerador/$denominador"
}
