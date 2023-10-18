package org.calc

import jdk.jfr.Description
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FracaoAdicaoTest {

    @Test
    fun `zero mais zero deve retornar zero`() {
        val a = Fracao(0)
        val b = Fracao(0)
        assertEquals(Fracao(0), a + b)
    }

    @Test
    fun `um mais um deve retornar dois`() {
        val a = Fracao(1)
        val b = Fracao(1)
        assertEquals(Fracao(2), a + b)
    }

    @Test
    fun `mesmo denominador`() {
        val a = Fracao(1, 3)
        val b = Fracao(4, 3)
        assertEquals(Fracao(5, 3), a + b)
    }

    @Test
    @Description("soma de frações com denominadores diferentes deve somar as frações equivalentes com denominador comum")
    fun `diferentes denominadores`() {
        // 1/3 + 4/5 = 5/15 + 12/15 = 17/15
        val a = Fracao(1, 3)
        val b = Fracao(4, 5)
        assertEquals(Fracao(17, 15), a + b)
    }

    @Test
    fun `menor fracao com numerador negativo`() {
        // -1/3 + 4/5 = -5/15 + 12/15 = 7/15
        val a = Fracao(-1, 3)
        val b = Fracao(4, 5)
        assertEquals(Fracao(7, 15), a + b)
    }

    @Test
    fun `maior fracao com numerador negativo`() {
        // 1/3 + (-4/5) = 5/15 + (-12/15) = -7/15
        val a = Fracao(1, 3)
        val b = Fracao(-4, 5)
        assertEquals(Fracao(-7, 15), a + b)
    }

    @Test
    fun `menor fracao com denominador negativo`() {
        // 1/-3 + 4/5 = -5/15 + 12/15 = 7/15
        val a = Fracao(1, -3)
        val b = Fracao(4, 5)
        assertEquals(Fracao(7, 15), a + b)
    }

    @Test
    fun `maior fracao com denominador negativo`() {
        // 1/3 + 4/-5 = 5/15 + (-12/15) = -7/15
        val a = Fracao(1, 3)
        val b = Fracao(4, -5)
        assertEquals(Fracao(-7, 15), a + b)
    }

    @Test
    fun `ambas fracoes negativas`() {
        // -1/3 + (-4/5) = -5/15 + (-12/15) = 7/15
        val a = Fracao(-1, 3)
        val b = Fracao(-4, 5)
        assertEquals(Fracao(-17, 15), a + b)
    }

    @Test
    fun `soma de denominadores diferentes deve simplificar resultado quando possivel`() {
        // 1/6 + 4/3 = 3/18 + 24/18 = 27/18 = 3/2
        val a = Fracao(1, 6)
        val b = Fracao(4, 3)
        assertEquals(Fracao(3, 2), a + b)
    }

    @Test
    fun `soma de denominadores iguais deve simplificar resultado quando possivel`() {
        // 1/9 + 5/9 = 6/9 = 2/3
        val a = Fracao(1, 9)
        val b = Fracao(5, 9)
        assertEquals(Fracao(2, 3), a + b)
    }
}
