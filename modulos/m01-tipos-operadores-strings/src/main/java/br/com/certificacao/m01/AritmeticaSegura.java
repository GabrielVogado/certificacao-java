package br.com.certificacao.m01;

/**
 * Exercício 1 — Aritmética segura com tipos primitivos.
 *
 * <p>Leia o enunciado completo (requisitos e RESTRIÇÕES) em {@code EXERCICIOS.md} antes de começar.
 * Os testes em {@code AritmeticaSeguraTest} são a especificação executável.
 */
public final class AritmeticaSegura {

    private AritmeticaSegura() {
    }

    /**
     * 1.1 — Soma {@code a + b}. Lança {@link ArithmeticException} se o resultado
     * matemático não couber em um {@code int}.
     */
    public static int somarExato(int a, int b) {
        throw new UnsupportedOperationException("TODO: exercício 1.1");
    }

    /**
     * 1.2 — Retorna o piso de {@code (a + b) / 2} calculado sobre os inteiros matemáticos
     * (ou seja, como se não existisse overflow), para QUALQUER par de {@code int}.
     */
    public static int mediaPiso(int a, int b) {
        throw new UnsupportedOperationException("TODO: exercício 1.2");
    }

    /**
     * 1.3 — Converte {@code valor} para {@code byte} SATURANDO nos limites do tipo,
     * em vez de "dar a volta" como faz o cast.
     */
    public static byte paraByteSaturado(int valor) {
        throw new UnsupportedOperationException("TODO: exercício 1.3");
    }
}
