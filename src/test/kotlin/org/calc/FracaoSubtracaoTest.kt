package org.calc

import jdk.jfr.Description
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FracaoSubtracaoTest {

    @Test
    fun `zero menos zero deve retornar zero`() {
        val a = Fracao(0)
        val b = Fracao(0)
        assertEquals(Fracao(0), a - b)
    }

    @Test
    fun `dois menos um deve retornar um`() {
        val a = Fracao(2)
        val b = Fracao(1)
        assertEquals(Fracao(1), a - b)
    }

    @Test
    fun `um terco menos um terco deve retornar zero`() {
        val a = Fracao(1, 3)
        val b = Fracao(1, 3)
        assertEquals(Fracao(0), a - b)
    }

    @Test
    fun `mesmo denominador`() {
        val a = Fracao(5, 3)
        val b = Fracao(1, 3)
        assertEquals(Fracao(4, 3), a - b)
    }

    @Test
    @Description("subtração de frações com denominadores diferentes deve subtrair as frações equivalentes com denominador comum")
    fun `diferentes denominadores`() {
        // 1/3 + 4/5 = 5/15 + 12/15 = 17/15
        val a = Fracao(4, 5)
        val b = Fracao(1, 3)
        assertEquals(Fracao(7, 15), a - b)
    }

    @Test
    fun `menor fracao com numerador negativo`() {
        // -1/3 + 4/5 = -5/15 + 12/15 = 7/15
        val a = Fracao(4, 5)
        val b = Fracao(-1, 3)
        assertEquals(Fracao(17, 15), a - b)
    }

    @Test
    fun `maior fracao com numerador negativo`() {
        // 1/3 + (-4/5) = 5/15 + (-12/15) = -7/15
        val a = Fracao(-4, 5)
        val b = Fracao(1, 3)
        assertEquals(Fracao(-17, 15), a - b)
    }

    @Test
    fun `ambas fracoes negativas`() {
        // -1/3 + (-4/5) = -5/15 + (-12/15) = 7/15
        val a = Fracao(-4, 5)
        val b = Fracao(-1, 3)
        assertEquals(Fracao(-7, 15), a - b)
    }

    @Test
    fun `subtracao de denominadores diferentes deve simplificar resultado quando possivel`() {
        // 7/6 - 1/2 = 7/6 - 2/6 = 4/6 = 2/3
        val a = Fracao(7, 6)
        val b = Fracao(1, 2)
        assertEquals(Fracao(2, 3), a - b)
    }

    @Test
    fun `subtracao de denominadores iguais deve simplificar resultado quando possivel`() {
        // 7/9 - 4/9 = 3/9 = 1/3
        val a = Fracao(7, 9)
        val b = Fracao(4, 9)
        assertEquals(Fracao(1, 3), a - b)
    }
}
