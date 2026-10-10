// Análise 03 — Operadores de bits, deslocamento e precedência.
// Previsão primeiro (ANALISE.md), depois:  java --source 11 A03_Bits.java
public class A03_Bits {
    public static void main(String[] args) {
        System.out.println(-8 >> 1);              // P1
        System.out.println(-8 >>> 28);            // P2
        System.out.println(1 << 32);              // P3
        System.out.println(1L << 32);             // P4
        System.out.println(5 & 3 | 4 ^ 1);        // P5
        System.out.println(~7);                   // P6
        boolean t = true, f = false;
        System.out.println(t ^ f & t | f);        // P7
        System.out.println(t | f && f);           // P8
    }
}
