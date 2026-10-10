package br.com.certificacao.m01;

/**
 * Exercício 3 — String, StringBuilder e a API de String do Java 11.
 *
 * <p>Leia o enunciado completo (requisitos e RESTRIÇÕES) em {@code EXERCICIOS.md}.
 * Os testes em {@code TextosTest} são a especificação executável.
 */
public final class Textos {

    private Textos() {
    }

    /**
     * 3.1 — Remove espaços em branco das extremidades e reduz cada sequência interna
     * de espaços em branco a um único caractere ' ' (U+0020).
     *
     * @throws IllegalArgumentException se {@code texto} for {@code null}
     */
    public static String normalizarEspacos(String texto) {
        throw new UnsupportedOperationException("TODO: exercício 3.1");
    }

    /**
     * 3.2 — Conta as linhas "úteis" de um texto: linhas que não estão em branco
     * e que não são comentários (começam com '#', ignorando espaços iniciais).
     *
     * @throws IllegalArgumentException se {@code texto} for {@code null}
     */
    public static long contarLinhasUteis(String texto) {
        throw new UnsupportedOperationException("TODO: exercício 3.2");
    }

    /**
     * 3.3 — Mascara um número de cartão, mantendo visíveis apenas os 4 últimos dígitos.
     *
     * @throws IllegalArgumentException se a entrada for inválida (ver EXERCICIOS.md)
     */
    public static String mascararCartao(String numero) {
        throw new UnsupportedOperationException("TODO: exercício 3.3");
    }

    /**
     * 3.4 — Compacta o texto usando run-length encoding: "aaabcc" vira "a3bc2".
     *
     * @throws IllegalArgumentException se {@code texto} for {@code null} ou contiver dígitos
     */
    public static String compactar(String texto) {
        throw new UnsupportedOperationException("TODO: exercício 3.4");
    }
}
