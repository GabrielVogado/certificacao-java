package br.com.certificacao.m01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComparadorNumericoTest {

    static Stream<Arguments> iguais() {
        return Stream.of(
                arguments(1, 1L),
                arguments((byte) -1, (short) -1),
                arguments(42, 42.0),
                arguments(0.5f, 0.5),
                arguments(0, -0.0),
                arguments(0.0f, -0.0),
                arguments(Double.NaN, Double.NaN),
                arguments(Float.NaN, Double.NaN),
                arguments(Float.POSITIVE_INFINITY, Double.POSITIVE_INFINITY),
                arguments(Double.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY),
                arguments(new BigDecimal("1.00"), 1),
                arguments(new BigDecimal("1.5"), 1.5),
                arguments(BigInteger.TWO.pow(64), 18446744073709551616.0),
                arguments(new BigInteger("-9223372036854775808"), Long.MIN_VALUE),
                arguments(new BigDecimal("1E+3"), (short) 1000)
        );
    }

    static Stream<Arguments> diferentes() {
        return Stream.of(
                arguments(1, 2L),
                arguments(0.1f, 0.1),
                arguments(new BigDecimal("0.1"), 0.1),
                arguments(9_007_199_254_740_993L, 9_007_199_254_740_992.0),
                arguments(Long.MAX_VALUE, (double) Long.MAX_VALUE),
                arguments(Integer.MAX_VALUE, (float) Integer.MAX_VALUE),
                arguments(Double.NaN, 0),
                arguments(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY),
                arguments(Double.POSITIVE_INFINITY, new BigDecimal("1E+400")),
                arguments(Double.MAX_VALUE, BigInteger.TWO.pow(1024)),
                arguments(new BigDecimal("1.0000000000000000000001"), 1)
        );
    }

    @ParameterizedTest(name = "[{index}] {0} == {1}")
    @MethodSource("iguais")
    void mesmoValor(Number a, Number b) {
        assertTrue(ComparadorNumerico.mesmoValor(a, b),
                () -> a + " (" + a.getClass().getSimpleName() + ") deveria ser igual a "
                        + b + " (" + b.getClass().getSimpleName() + ")");
    }

    @ParameterizedTest(name = "[{index}] {0} != {1}")
    @MethodSource("diferentes")
    void valoresDiferentes(Number a, Number b) {
        assertFalse(ComparadorNumerico.mesmoValor(a, b),
                () -> a + " (" + a.getClass().getSimpleName() + ") NÃO deveria ser igual a "
                        + b + " (" + b.getClass().getSimpleName() + ")");
    }

    @ParameterizedTest(name = "[{index}] simetria: {0} e {1}")
    @MethodSource({"iguais", "diferentes"})
    void eSimetrico(Number a, Number b) {
        assertEquals(ComparadorNumerico.mesmoValor(a, b), ComparadorNumerico.mesmoValor(b, a));
    }

    @Test
    @DisplayName("null ou tipo não suportado lança IllegalArgumentException")
    void entradasInvalidas() {
        assertThrows(IllegalArgumentException.class, () -> ComparadorNumerico.mesmoValor(null, 1));
        assertThrows(IllegalArgumentException.class, () -> ComparadorNumerico.mesmoValor(1, null));
        assertThrows(IllegalArgumentException.class,
                () -> ComparadorNumerico.mesmoValor(new AtomicInteger(1), 1));
    }
}
