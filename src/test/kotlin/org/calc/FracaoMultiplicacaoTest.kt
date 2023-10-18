package org.calc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FracaoMultiplicacaoTest {

    @Test
    fun `zero vezes zero deve retornar zero`() {
        val a = Fracao(0)
        val b = Fracao(0)
        assertEquals(Fracao(0), a * b)
    }

    @Test
    fun `dois vezes zero deve retornar zero`() {
        val a = Fracao(2)
        val b = Fracao(0)
        assertEquals(Fracao(0), a * b)
    }

    @Test
    fun `dois vezes um deve retornar dois`() {
        val a = Fracao(2)
        val b = Fracao(1)
        assertEquals(Fracao(2), a * b)
    }

    @Test
    fun `positivo vezes negativo`() {
        val a = Fracao(4, 5)
        val b = Fracao(-1, 3)
        assertEquals(Fracao(-4, 15), a * b)
    }

    @Test
    fun `negativo vezes negativo`() {
        // -1/3 + (-4/5) = -5/15 + (-12/15) = 7/15
        val a = Fracao(-4, 5)
        val b = Fracao(-1, 3)
        assertEquals(Fracao(4, 15), a * b)
    }

    @Test
    fun `produto nao simplificavel`() {
        val a = Fracao(5, 2)
        val b = Fracao(1, 3)
        assertEquals(Fracao(5, 6), a * b)
    }

    @Test
    fun `produto simplificavel`() {
        val a = Fracao(6, 3)
        val b = Fracao(1, 5)
        assertEquals(Fracao(2, 5), a * b)
    }
}
