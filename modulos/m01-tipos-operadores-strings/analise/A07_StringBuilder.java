// Análise 07 — StringBuilder: mutabilidade, encadeamento e índices.
// Previsão primeiro (ANALISE.md), depois:  java --source 11 A07_StringBuilder.java
public class A07_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1).append('1').append("1").append(1.0f).append(true);
        System.out.println(sb + " " + sb.length());                              // P1
        sb.setLength(3);
        System.out.println(sb.reverse());                                        // P2
        StringBuilder a = new StringBuilder("java");
        StringBuilder b = a.append("11");
        b.insert(0, '[').append(']');
        System.out.println(a + " " + (a == b));                                  // P3
        StringBuilder c = new StringBuilder("0123456789");
        c.delete(2, 4).deleteCharAt(0).replace(1, 3, "AB");
        System.out.println(c + " " + c.indexOf("A") + " " + c.charAt(c.length() - 1)); // P4
        String pedaco = c.substring(2, 4);
        System.out.println(pedaco);                                              // P5
    }
}
