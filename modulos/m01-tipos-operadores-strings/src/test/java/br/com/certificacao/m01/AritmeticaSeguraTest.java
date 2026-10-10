package br.com.certificacao.m01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AritmeticaSeguraTest {

    private static final int MAX = Integer.MAX_VALUE;
    private static final int MIN = Integer.MIN_VALUE;

    @Nested
    @DisplayName("1.1 somarExato")
    class SomarExato {

        @ParameterizedTest(name = "{0} + {1} = {2}")
        @CsvSource({
                "1, 2, 3",
                "-7, 3, -4",
                "2147483647, 0, 2147483647",
                "-2147483648, 0, -2147483648",
                "2147483647, -2147483648, -1",
                "2147483646, 1, 2147483647",
                "-2147483647, -1, -2147483648",
                "1000000000, 1000000000, 2000000000"
        })
        void somaSemOverflow(int a, int b, int esperado) {
            assertEquals(esperado, AritmeticaSegura.somarExato(a, b));
        }

        @ParameterizedTest(name = "{0} + {1} estoura")
        @CsvSource({
                "2147483647, 1",
                "-2147483648, -1",
                "2147483647, 2147483647",
                "-2147483648, -2147483648",
                "1500000000, 1000000000",
                "-1500000000, -1000000000"
        })
        void somaComOverflowLancaExcecao(int a, int b) {
            assertThrows(ArithmeticException.class, () -> AritmeticaSegura.somarExato(a, b));
        }

        @Test
        @DisplayName("concorda com a matemática em 100 mil pares aleatórios")
        void propriedade() {
            Random random = new Random(42);
            for (int i = 0; i < 100_000; i++) {
                int a = random.nextInt();
                int b = random.nextInt();
                long exato = (long) a + b;
                if (exato > MAX || exato < MIN) {
                    assertThrows(ArithmeticException.class, () -> AritmeticaSegura.somarExato(a, b),
                            () -> a + " + " + b + " deveria estourar");
                } else {
                    assertEquals((int) exato, AritmeticaSegura.somarExato(a, b), () -> a + " + " + b);
                }
            }
        }
    }

    @Nested
    @DisplayName("1.2 mediaPiso")
    class MediaPiso {

        @ParameterizedTest(name = "piso(({0} + {1}) / 2) = {2}")
        @CsvSource({
                "2, 4, 3",
                "3, 4, 3",
                "-3, -4, -4",
                "-3, 4, 0",
                "3, -4, -1",
                "0, -1, -1",
                "2147483647, 2147483647, 2147483647",
                "-2147483648, -2147483648, -2147483648",
                "2147483647, -2147483648, -1",
                "2147483647, 2147483646, 2147483646",
                "-2147483648, -2147483647, -2147483648"
        })
        void casosDeBorda(int a, int b, int esperado) {
            assertEquals(esperado, AritmeticaSegura.mediaPiso(a, b));
        }

        @Test
        @DisplayName("é comutativa e concorda com a matemática em 100 mil pares aleatórios")
        void propriedade() {
            Random random = new Random(7);
            for (int i = 0; i < 100_000; i++) {
                int a = random.nextInt();
                int b = random.nextInt();
                int esperado = (int) Math.floorDiv((long) a + b, 2L);
                assertEquals(esperado, AritmeticaSegura.mediaPiso(a, b), () -> "media(" + a + ", " + b + ")");
                assertEquals(esperado, AritmeticaSegura.mediaPiso(b, a), () -> "media(" + b + ", " + a + ")");
            }
        }
    }

    @Nested
    @DisplayName("1.3 paraByteSaturado")
    class ParaByteSaturado {

        @ParameterizedTest(name = "{0} -> {1}")
        @CsvSource({
                "0, 0",
                "-1, -1",
                "127, 127",
                "-128, -128",
                "128, 127",
                "200, 127",
                "300, 127",
                "-129, -128",
                "-300, -128",
                "2147483647, 127",
                "-2147483648, -128"
        })
        void satura(int valor, byte esperado) {
            assertEquals(esperado, AritmeticaSegura.paraByteSaturado(valor));
        }
    }
}
