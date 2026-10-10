// Análise 08 — "Compila ou não compila?" (a pergunta mais comum da prova).
// 1) Marque em ANALISE.md quais linhas (L1..L15) NÃO compilam e por quê.
// 2) Só depois compile:  javac --release 11 -d saida A08_Compila.java
//    O javac lista todos os erros de uma vez; confira linha por linha.
import java.util.ArrayList;

public class A08_Compila {
    public static void main(String[] args) {
        var a = 10;                              // L1
        a = 20L;                                 // L2
        var b = (short) 5;                       // L3
        b = b + 1;                               // L4
        b += 1;                                  // L5
        var c = new ArrayList<String>();         // L6
        c.add(1);                                // L7
        char d = 'x' + 1;                        // L8
        char e = d + 1;                          // L9
        final int f = 10;
        byte g = f;                              // L10
        int h = 10;
        byte i = h;                              // L11
        float k = 1_0.0f;                        // L12
        boolean l = 1;                           // L13
        Object m = 'a' + 1;                      // L14
        int[] n = {1, 2,};                       // L15
    }
}
