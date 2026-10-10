// Análise 05 — Wrappers, autoboxing e unboxing.
// Previsão primeiro (ANALISE.md), depois:  java --source 11 A05_Wrappers.java
public class A05_Wrappers {
    public static void main(String[] args) {
        Integer a = 1000, b = 1000;
        System.out.println(a.equals(b) + " " + (a == b) + " " + (a <= b && a >= b));  // P1
        Long l = 10L;
        System.out.println(l.equals(10) + " " + l.equals(10L) + " " + (l == 10));    // P2
        System.out.println(Integer.parseInt("+42") + Integer.valueOf("-2"));         // P3
        System.out.println(Boolean.parseBoolean("TRUE") + " " + Boolean.parseBoolean("yes")); // P4
        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));            // P5
        Character ch = 'x';
        System.out.println(Character.isLetter(ch) + " " + Character.toUpperCase(ch)); // P6
        Integer n = null;
        try {
            int x = n;
            System.out.println(x);
        } catch (NullPointerException e) {
            System.out.println("NPE");                                              // P7
        }
        System.out.println(Integer.compare(3, 7) + " " + Integer.signum(-99) + " "
                + Integer.MAX_VALUE + Integer.MIN_VALUE);                           // P8
    }
}
