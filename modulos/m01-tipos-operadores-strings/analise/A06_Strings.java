// Análise 06 — API de String (Java 8 a 11) e imutabilidade.
// Previsão primeiro (ANALISE.md), depois:  java --source 11 A06_Strings.java
public class A06_Strings {
    public static void main(String[] args) {
        String s = "Java Certification";
        System.out.println(s.substring(5).length() + s.indexOf('a', 2) + s.lastIndexOf("i")); // P1
        System.out.println("abc".substring(3).isEmpty());                        // P2
        System.out.println("abc".substring(1, 1).length());                      // P3
        System.out.println("a,b,,c,,".split(",").length);                        // P4
        System.out.println("A\nB\r\nC\n".lines().count());                       // P5
        System.out.println("ab".repeat(3).replace("ba", "_"));                   // P6
        System.out.println("Hello".chars().filter(c -> c == 'l').count());       // P7
        System.out.println("  x ".strip().length() + " " + "  x ".stripLeading().length()
                + " " + "  x ".stripTrailing().length());                        // P8
        String t = "imutavel";
        t.toUpperCase();
        t.concat("!");
        System.out.println(t);                                                   // P9
        System.out.println("b".compareTo("a") + " " + "apple".compareTo("apricot")
                + " " + "a".compareTo("abc"));                                   // P10
    }
}
