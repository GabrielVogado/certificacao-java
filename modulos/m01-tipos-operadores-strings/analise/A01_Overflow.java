// Análise 01 — Overflow de inteiros.
// 1) Escreva sua previsão para CADA println em ANALISE.md.
// 2) Só depois execute:  java --source 11 A01_Overflow.java
public class A01_Overflow {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        System.out.println(max + 1);                                  // P1
        System.out.println(Math.abs(Integer.MIN_VALUE));              // P2
        System.out.println(-Integer.MIN_VALUE == Integer.MIN_VALUE);  // P3
        System.out.println((long) max + 1);                           // P4
        System.out.println((long) (max + 1));                         // P5
        System.out.println(Integer.MIN_VALUE / -1);                   // P6
        System.out.println(Integer.MIN_VALUE % -1);                   // P7
        System.out.println((byte) 200 + " " + (short) 70_000);        // P8
    }
}
