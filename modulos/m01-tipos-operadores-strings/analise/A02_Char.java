// Análise 02 — char é um tipo numérico.
// Previsão primeiro (ANALISE.md), depois:  java --source 11 A02_Char.java
public class A02_Char {
    public static void main(String[] args) {
        char c = 'a';
        c++;
        c += 2;
        System.out.println(c);                    // P1
        System.out.println(c + 1);                // P2
        System.out.println((char) (c + 1));       // P3
        System.out.println("" + c + 1);           // P4
        System.out.println(c + 1 + "");           // P5
        System.out.println('a' + 'b' + "c");      // P6
        System.out.println("c" + 'a' + 'b');      // P7
        char d = 65;
        int i = 'z' - 'a';
        System.out.println(d + " " + i);          // P8
    }
}
