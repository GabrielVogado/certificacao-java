package br.com.certificacao.m01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class TextosTest {

    // 3.1 normalizarEspacos ----------------------------------------

    static Stream<Arguments> normalizarCasos() {
        return Stream.of(
                arguments("  a   b  ", "a b"),
                arguments("x", "x"),
                arguments("", ""),
                arguments("   ", ""),
                arguments("\t\nJava\u2003\u2003 11\r\n", "Java 11"),
                arguments("a\u00A0b", "a\u00A0b"),
                arguments("\u2003\u2003fim", "fim"),
                arguments("um\t\tdois\n\ntres", "um dois tres")
        );
    }

    @ParameterizedTest(name = "[{index}]")
    @MethodSource("normalizarCasos")
    void normaliza(String entrada, String esperado) {
        assertEquals(esperado, Textos.normalizarEspacos(entrada));
    }

    @Test
    void normalizarNullLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> Textos.normalizarEspacos(null));
    }

    // 3.2 contarLinhasUteis ----------------------------------------

    static Stream<Arguments> contarLinhasCasos() {
        return Stream.of(
                arguments("a\n\n  \n# comentario\n  #outro\nb\r\nc", 3L),
                arguments("", 0L),
                arguments("\n\n", 0L),
                arguments("x", 1L),
                arguments("  \u2003  \n y", 1L),
                arguments("a\rb", 2L),
                arguments("valor # com cerquilha no meio\n#", 1L)
        );
    }

    @ParameterizedTest(name = "[{index}] esperado {1}")
    @MethodSource("contarLinhasCasos")
    void conta(String texto, long esperado) {
        assertEquals(esperado, Textos.contarLinhasUteis(texto));
    }

    @Test
    void contarLinhasNullLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> Textos.contarLinhasUteis(null));
    }

    // 3.3 mascararCartao ----------------------------------------

    static Stream<Arguments> mascararValidos() {
        return Stream.of(
                arguments("4111 1111 1111 1234", "************1234"),
                arguments("3782-822463-10005", "***********0005"),
                arguments("4222222222222", "*********2222"),
                arguments("6011 0009 9013 9424 123", "***************4123")
        );
    }

    @ParameterizedTest(name = "[{index}] {1}")
    @MethodSource("mascararValidos")
    void mascara(String numero, String esperado) {
        assertEquals(esperado, Textos.mascararCartao(numero));
    }

    @ParameterizedTest(name = "[{index}] entrada inválida")
    @ValueSource(strings = {
            "",
            "4111 1111 1111",
            "4111 1111 1111 1234 5678",
            "4111 1111 1111 123X",
            "4111.1111.1111.1234",
            "\uFF14\uFF11\uFF11\uFF11\uFF11\uFF11\uFF11\uFF11\uFF11\uFF11\uFF11\uFF11\uFF11"
    })
    void entradaInvalidaLancaExcecao(String numero) {
        assertThrows(IllegalArgumentException.class, () -> Textos.mascararCartao(numero));
    }

    @Test
    void mascararNullLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> Textos.mascararCartao(null));
    }

    @Test
    @DisplayName("a mensagem de erro não vaza o número do cartão")
    void mensagemNaoVazaDadoSensivel() {
        String numero = "4111-2222-3333-9876-5432-1";
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> Textos.mascararCartao(numero));
        String mensagem = String.valueOf(erro.getMessage());
        for (String trecho : new String[] {"4111", "2222", "3333", "9876", "5432", "4321"}) {
            assertFalse(mensagem.contains(trecho), "a mensagem expõe parte do cartão: " + mensagem);
        }
    }

    // 3.4 compactar ----------------------------------------

    static Stream<Arguments> compactarCasos() {
        return Stream.of(
                arguments("aaabccdddd", "a3bc2d4"),
                arguments("", ""),
                arguments("a", "a"),
                arguments("abc", "abc"),
                arguments("zzzzzzzzzzzz", "z12"),
                arguments("aabbaa", "a2b2a2"),
                arguments("  !!", " 2!2")
        );
    }

    @ParameterizedTest(name = "[{index}] {0} -> {1}")
    @MethodSource("compactarCasos")
    void compacta(String entrada, String esperado) {
        assertEquals(esperado, Textos.compactar(entrada));
    }

    @ParameterizedTest(name = "[{index}] entrada inválida")
    @ValueSource(strings = {"a1", "9"})
    void digitosLancamExcecao(String entrada) {
        assertThrows(IllegalArgumentException.class, () -> Textos.compactar(entrada));
    }

    @Test
    void compactarNullLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> Textos.compactar(null));
    }
}
