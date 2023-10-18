package org.calc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class FracaoTest {

    @Test
    fun `sinal de denominador negativo deve ir para numerador 1`() {
        // 1/-3 = -1/3
        assertEquals(Fracao(-1, 3), Fracao(1, -3))
    }

    @Test
    fun `sinal de denominador negativo deve ir para numerador 2`() {
        // -1/-3 = 1/3
        assertEquals(Fracao(1, 3), Fracao(-1, -3))
    }

    @Test
    fun `denominador zero deve lancar excecao`() {
        assertThrows(IllegalArgumentException::class.java) {
            Fracao(1, 0)
        }
    }
}
