package br.com.certificacao.m01;

/**
 * Exercício 2 — Igualdade numérica entre wrappers e tipos de precisão arbitrária.
 *
 * <p>Leia o enunciado completo em {@code EXERCICIOS.md}.
 * Os testes em {@code ComparadorNumericoTest} são a especificação executável.
 */
public final class ComparadorNumerico {

    private ComparadorNumerico() {
    }

    /**
     * Indica se {@code a} e {@code b} representam exatamente o mesmo valor matemático,
     * independentemente do tipo concreto de cada um.
     *
     * <p>Tipos suportados: {@code Byte}, {@code Short}, {@code Integer}, {@code Long},
     * {@code Float}, {@code Double}, {@code java.math.BigInteger} e {@code java.math.BigDecimal}.
     *
     * @throws IllegalArgumentException se algum argumento for {@code null} ou de tipo não suportado
     */
    public static boolean mesmoValor(Number a, Number b) {
        throw new UnsupportedOperationException("TODO: exercício 2");
    }
}
