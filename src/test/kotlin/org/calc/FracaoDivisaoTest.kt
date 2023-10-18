package org.calc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class FracaoDivisaoTest {

    @Test
    fun zero_dividido_zero_deve_lancar_excecao() {
        val a = Fracao(0)
        val b = Fracao(0)
        val e = assertThrows(IllegalArgumentException::class.java) { a / b }
        assertEquals("0/0 -> Resultado indefinido", e.message)
    }

    @Test
    fun dois_dividido_zero_deve_lancar_excecao() {
        val a = Fracao(2)
        val b = Fracao(0)
        val e = assertThrows(IllegalArgumentException::class.java) { a / b }
        assertEquals("Não é possível dividir por zero", e.message)
    }

    @Test
    fun dois_dividido_um_deve_retornar_dois() {
        val a = Fracao(2)
        val b = Fracao(1)
        assertEquals(Fracao(2), a / b)
    }

    @Test
    fun positivo_dividido_negativo() {
        val a = Fracao(4, 5)
        val b = Fracao(-1, 3)
        assertEquals(Fracao(-12, 5), a / b)
    }

    @Test
    fun negativo_dividido_negativo() {
        // -1/3 + (-4/5) = -5/15 + (-12/15) = 7/15
        val a = Fracao(-4, 5)
        val b = Fracao(-1, 3)
        assertEquals(Fracao(12, 5), a / b)
    }

    @Test
    fun produto_nao_simplificavel() {
        val a = Fracao(3, 2)
        val b = Fracao(1, 5)
        assertEquals(Fracao(15, 2), a / b)
    }

    @Test
    fun produto_simplificavel() {
        val a = Fracao(5, 6)
        val b = Fracao(5, 2)
        assertEquals(Fracao(1, 3), a / b)
    }
}
