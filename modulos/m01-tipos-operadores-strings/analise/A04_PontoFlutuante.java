// Análise 04 — float, double, NaN, infinito e -0.0.
// Previsão primeiro (ANALISE.md), depois:  java --source 11 A04_PontoFlutuante.java
public class A04_PontoFlutuante {
    public static void main(String[] args) {
        System.out.println(0.1f == 0.1);                                    // P1
        System.out.println((float) 0.1 == 0.1f);                            // P2
        System.out.println(0.1 + 0.2);                                      // P3
        System.out.println(1.0 / 0);                                        // P4
        System.out.println(-0.0 == 0.0);                                    // P5
        System.out.println(Double.valueOf(-0.0).equals(0.0));               // P6
        System.out.println(Double.NaN == Double.NaN);                       // P7
        System.out.println(Double.valueOf(Double.NaN).equals(Double.NaN));  // P8
        System.out.println((int) 3.99 + " " + (int) -3.99 + " "
                + Math.round(-3.5) + " " + Math.round(3.5));                // P9
        System.out.println((int) Double.NaN + " " + (int) 1e20);            // P10
    }
}
