package org.calc

import jdk.jfr.Description
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class FracaoAdicaoTest {

    @Test
    fun zero_mais_zero_deve_retornar_zero() {
        val a = Fracao(0)
        val b = Fracao(0)
        assertEquals(Fracao(0), a + b)
    }

    @Test
    fun um_mais_um_deve_retornar_dois() {
        val a = Fracao(1)
        val b = Fracao(1)
        assertEquals(Fracao(2), a + b)
    }

    @Test
    fun mesmo_denominador() {
        val a = Fracao(1, 3)
        val b = Fracao(4, 3)
        assertEquals(Fracao(5, 3), a + b)
    }

    @Test
    @Description("soma de frações com denominadores diferentes deve somar as frações equivalentes com denominador comum")
    fun diferentes_denominadores() {
        // 1/3 + 4/5 = 5/15 + 12/15 = 17/15
        val a = Fracao(1, 3)
        val b = Fracao(4, 5)
        assertEquals(Fracao(17, 15), a + b)
    }

    @Test
    fun menor_fracao_com_numerador_negativo() {
        // -1/3 + 4/5 = -5/15 + 12/15 = 7/15
        val a = Fracao(-1, 3)
        val b = Fracao(4, 5)
        assertEquals(Fracao(7, 15), a + b)
    }

    @Test
    fun maior_fracao_com_numerador_negativo() {
        // 1/3 + (-4/5) = 5/15 + (-12/15) = -7/15
        val a = Fracao(1, 3)
        val b = Fracao(-4, 5)
        assertEquals(Fracao(-7, 15), a + b)
    }

    @Test
    fun menor_fracao_com_denominador_negativo() {
        // 1/-3 + 4/5 = -5/15 + 12/15 = 7/15
        val a = Fracao(1, -3)
        val b = Fracao(4, 5)
        assertEquals(Fracao(7, 15), a + b)
    }

    @Test
    fun maior_fracao_com_denominador_negativo() {
        // 1/3 + 4/-5 = 5/15 + (-12/15) = -7/15
        val a = Fracao(1, 3)
        val b = Fracao(4, -5)
        assertEquals(Fracao(-7, 15), a + b)
    }

    @Test
    fun ambas_fracoes_negativas() {
        // -1/3 + (-4/5) = -5/15 + (-12/15) = 7/15
        val a = Fracao(-1, 3)
        val b = Fracao(-4, 5)
        assertEquals(Fracao(-17, 15), a + b)
    }

    @Test
    fun soma_de_denominadores_diferentes_deve_simplificar_resultado_quando_possivel() {
        // 1/6 + 4/3 = 3/18 + 24/18 = 27/18 = 3/2
        val a = Fracao(1, 6)
        val b = Fracao(4, 3)
        assertEquals(Fracao(3, 2), a + b)
    }

    @Test
    fun soma_de_denominadores_iguais_deve_simplificar_resultado_quando_possivel() {
        // 1/9 + 5/9 = 6/9 = 2/3
        val a = Fracao(1, 9)
        val b = Fracao(5, 9)
        assertEquals(Fracao(2, 3), a + b)
    }
}
