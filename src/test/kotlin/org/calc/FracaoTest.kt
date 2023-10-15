package org.calc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class FracaoTest {

    @Test
    fun sinal_de_denominador_negativo_deve_ir_para_numerador1() {
        // 1/-3 = -1/3
        assertEquals(Fracao(-1, 3), Fracao(1, -3))
    }

    @Test
    fun sinal_de_denominador_negativo_deve_ir_para_numerador2() {
        // -1/-3 = 1/3
        assertEquals(Fracao(1, 3), Fracao(-1, -3))
    }

    @Test
    fun denominador_zero_deve_lancar_excecao() {
        assertThrows(IllegalArgumentException::class.java) {
            Fracao(1, 0)
        }
    }
}
