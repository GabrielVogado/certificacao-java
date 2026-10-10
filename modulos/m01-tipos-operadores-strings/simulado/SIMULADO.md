# Simulado M01: Data Types, Operators, `var`, Wrappers and Strings

| Item | Valor |
|---|---|
| Questões | 20 |
| Tempo | **36 minutos** (1,8 min por questão, o mesmo ritmo da 1Z0-819) |
| Nota de corte | **68%** (14 acertos), a mesma das provas oficiais |
| Versão da linguagem | Java 11 (`--release 11`) |

## Regras (como no dia da prova)

1. **Não compile, não execute e não pesquise** nada até enviar as respostas. Nada de IDE, JShell, internet ou IA.
2. Anote o horário de início e de fim em [`RESPOSTAS.md`](RESPOSTAS.md).
3. Questões *"Choose two/three"* exigem **todas** as alternativas corretas. Não há crédito parcial, assim como na Oracle.
4. Tente ler primeiro em inglês. Abra a tradução 🇧🇷 só quando travar e marque a coluna "Usei tradução" na folha de respostas.
5. Em cada questão, registre sua confiança: 1 = chutei, 2 = acho que sim, 3 = tenho certeza.
6. Quando terminar, peça ao tutor: **"corrija o simulado do M01"**.

> Salvo indicação contrária, assuma que todo o código está em um arquivo com o nome correto e que os imports necessários estão presentes.

---

### Question 1

Which two method declarations, placed in a public class, allow that class to be launched with `java ClassName` on Java 11? **(Choose two.)**

- A. `public void static main(String[] args)`
- B. `public static void main(String... args)`
- C. `public static int main(String[] args)`
- D. `private static void main(String[] args)`
- E. `final static public void main(String[] _args)`
- F. `public static void main(String args)`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 1.** Quais duas declarações de método, colocadas em uma classe pública, permitem que essa classe seja iniciada com `java ClassName` no Java 11? **(Escolha duas.)**

📖 *placed in* = colocado(a) em · *to be launched* = ser iniciado/executado · *method declaration* = declaração de método
</details>

---

### Question 2

Given:

```java
public class Defaults {
    static int count;
    static String name;
    boolean flag;

    public static void main(String[] args) {
        int local;
        double[] values = new double[2];
        if (args.length >= 0) local = 1;
        System.out.println(count + " " + name + " " + values[1]);
        System.out.println(local);
    }
}
```

What is the result?

- A. `0 null 0.0` followed by `1`
- B. `0 null 0.0` followed by `0`
- C. `0 null null` followed by `1`
- D. Compilation fails.
- E. A `NullPointerException` is thrown at runtime.

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 2.** Dado o código acima, qual é o resultado?

- A. `0 null 0.0` seguido de `1`
- B. `0 null 0.0` seguido de `0`
- C. `0 null null` seguido de `1`
- D. A compilação falha.
- E. Uma `NullPointerException` é lançada em tempo de execução.

📖 *Given* = dado · *followed by* = seguido de · *compilation fails* = a compilação falha · *is thrown at runtime* = é lançada em tempo de execução
</details>

---

### Question 3

Given:

```java
public class Literals {
    public static void main(String[] args) {
        int a = 1_000_000;                    // L1
        int b = 0b1010_1010;                  // L2
        long c = 9_223_372_036_854_775_807;   // L3
        double d = 1_000.5_0;                 // L4
        float e = 3.14;                       // L5
        int f = 0x_FF;                        // L6
        int g = 1__2;                         // L7
        int h = 017;                          // L8
        int i = 09;                           // L9
    }
}
```

How many of the lines marked `L1` to `L9` fail to compile? Consider each line independently.

- A. Two
- B. Three
- C. Four
- D. Five
- E. Six

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 3.** Quantas das linhas marcadas de `L1` a `L9` não compilam? Considere cada linha isoladamente.

- A. Duas · B. Três · C. Quatro · D. Cinco · E. Seis

📖 *How many* = quantos(as) · *lines marked* = linhas marcadas · *fail to compile* = não compilam · *independently* = isoladamente
</details>

---

### Question 4

Given:

```java
public class Division {
    public static void main(String[] args) {
        var x = 7;
        var y = 2;
        var r1 = x / y;
        var r2 = x / (double) y;
        var r3 = x % -y;
        var r4 = -x % y;
        System.out.println(r1 + " " + r2 + " " + r3 + " " + r4);
    }
}
```

What is the output?

- A. `3 3.5 -1 -1`
- B. `3.5 3.5 1 -1`
- C. `3 3.5 1 -1`
- D. `3 3.5 -1 1`
- E. `3 3.0 1 -1`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 4.** Qual é a saída?

📖 *output* = saída (o que é impresso)
</details>

---

### Question 5

Which three are valid names for a local variable in Java 11? **(Choose three.)**

- A. `_`
- B. `$value`
- C. `2ndPlace`
- D. `var`
- E. `const`
- F. `Public`
- G. `goto`
- H. `num#`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 5.** Quais três são nomes válidos para uma variável local no Java 11? **(Escolha três.)**

📖 *valid names* = nomes válidos · *local variable* = variável local
</details>

---

### Question 6

Given:

```java
public class Ternary {
    public static void main(String[] args) {
        Integer value = null;
        boolean ok = true;
        System.out.print(ok ? 1 : 2.0);
        System.out.print(" ");
        Integer x = ok ? value : Integer.valueOf(0);
        System.out.print(x);
        System.out.print(" ");
        Integer y = ok ? value : 0;
        System.out.print(y);
    }
}
```

What is the result?

- A. `1 null null`
- B. `1.0 null null`
- C. `1 null ` followed by a `NullPointerException`
- D. `1.0 null ` followed by a `NullPointerException`
- E. Compilation fails.

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 6.** Qual é o resultado?

- C. `1 null ` seguido de uma `NullPointerException`
- D. `1.0 null ` seguido de uma `NullPointerException`
- E. A compilação falha.

📖 *result* = resultado · *followed by* = seguido de
</details>

---

### Question 7

Which two lines compile when placed inside a method body? Assume `java.util.*` is imported. **(Choose two.)**

- A. `var x = null;`
- B. `var arr = {1, 2, 3};`
- C. `var list = new ArrayList<>();`
- D. `var a = 1, b = 2;`
- E. `var lambda = () -> 42;`
- F. `var var = "var";`
- G. `var n;`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 7.** Quais duas linhas compilam quando colocadas dentro do corpo de um método? Assuma que `java.util.*` está importado. **(Escolha duas.)**

📖 *method body* = corpo do método · *Assume* = assuma/considere · *is imported* = está importado
</details>

---

### Question 8

Given:

```java
public class Compound {
    public static void main(String[] args) {
        byte b = 10;
        b += 300;
        char c = 'a';
        c += 1;
        int i = c + b;
        System.out.println(b + " " + c + " " + i);
    }
}
```

What is the result?

- A. `310 b 408`
- B. `54 98 152`
- C. `-46 b 52`
- D. Compilation fails.
- E. `54 b 152`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 8.** Qual é o resultado? (D. A compilação falha.)

📖 *compound assignment* = atribuição composta (`+=`, `-=`, ...)
</details>

---

### Question 9

Given:

```java
package app;

import java.util.*;
import java.sql.*;

public class Repo {
    Date created;
}
```

The class does not compile. Which three changes, each applied independently, make the class compile? **(Choose three.)**

- A. Add `import java.lang.*;`
- B. Add `import java.util.Date;`
- C. Replace `import java.sql.*;` with `import java.sql.Date;`
- D. Move both import statements below the class declaration.
- E. Change the field declaration to `java.util.Date created;`
- F. Add both `import java.util.Date;` and `import java.sql.Date;`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 9.** A classe não compila. Quais três mudanças, cada uma aplicada de forma independente, fazem a classe compilar? **(Escolha três.)**

- A. Adicionar `import java.lang.*;`
- B. Adicionar `import java.util.Date;`
- C. Substituir `import java.sql.*;` por `import java.sql.Date;`
- D. Mover os dois imports para baixo da declaração da classe.
- E. Mudar a declaração do campo para `java.util.Date created;`
- F. Adicionar `import java.util.Date;` e também `import java.sql.Date;`

📖 *each applied independently* = cada uma aplicada isoladamente · *Replace X with Y* = substituir X por Y · *field* = atributo/campo
</details>

---

### Question 10

Given:

```java
public class Increment {
    public static void main(String[] args) {
        int x = 5;
        int y = x++ + ++x * x--;
        System.out.println(x + " " + y);
    }
}
```

What is the output?

- A. `5 54`
- B. `6 54`
- C. `6 47`
- D. `7 54`
- E. `6 59`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 10.** Qual é a saída?

📖 *pre-increment* = pré-incremento (`++x`) · *post-decrement* = pós-decremento (`x--`)
</details>

---

### Question 11

Given:

```java
public class Pool {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Ja" + "va";
        final String p = "Ja";
        String s3 = p + "va";
        String q = "Ja";
        String s4 = q + "va";
        String s5 = s4.intern();
        String s6 = new String("Java");
        System.out.println((s1 == s2) + " " + (s1 == s3) + " " + (s1 == s4)
                + " " + (s1 == s5) + " " + s1.equals(s6));
    }
}
```

What is the output?

- A. `true true false true true`
- B. `true false false true true`
- C. `true true true true true`
- D. `true false false false true`
- E. `false false false true true`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 11.** Qual é a saída?

📖 *string pool* = pool de strings (área onde literais são reaproveitados) · *compile-time constant* = constante em tempo de compilação
</details>

---

### Question 12

Given:

```java
public class ShortCircuit {
    public static void main(String[] args) {
        int a = 0, b = 0;
        boolean r = (a++ > 0) && (b++ > 0) | (++b > 1);
        boolean s = (a++ > 0) || (b++ > 0) & (++b > 1);
        System.out.println(a + " " + b + " " + r + " " + s);
    }
}
```

What is the output?

- A. `2 2 false true`
- B. `1 0 false true`
- C. `2 1 false true`
- D. `2 0 true true`
- E. `2 0 false true`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 12.** Qual é a saída?

📖 *short-circuit operator* = operador de curto-circuito (`&&`, `||`) · *precedence* = precedência
</details>

---

### Question 13

Given:

```java
public class Strip {
    public static void main(String[] args) {
        String text = " \u2003 Java 11 \t";   // \u2003 is an EM SPACE (Unicode whitespace)
        System.out.println(text.trim().length() + " " + text.strip().length());
        System.out.println(text.isBlank() + " " + "  ".isEmpty() + " " + "x".repeat(0).isEmpty());
    }
}
```

What is the output?

- A. `7 7` and `false false true`
- B. `9 9` and `false true true`
- C. `9 7` and `false false true`
- D. `9 7` and `true false true`
- E. `7 7` and `true false false`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 13.** Qual é a saída? (Cada alternativa mostra a 1ª linha "e" (*and*) a 2ª linha.) `\u2003` é um EM SPACE, um caractere de espaço em branco do Unicode.

📖 *whitespace* = espaço em branco · *blank* = em branco (só espaços) · *empty* = vazio (comprimento zero)
</details>

---

### Question 14

Given:

```java
public class Chain {
    public static void main(String[] args) {
        String s = "certification";
        System.out.println(s.substring(4, 8).toUpperCase().indexOf('I')
                + s.charAt(s.length() - 3) + s.indexOf("i", 6));
    }
}
```

What is the output?

- A. `111`
- B. `0i6`
- C. `0i10`
- D. `105`
- E. A `StringIndexOutOfBoundsException` is thrown.

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 14.** Qual é a saída? (E. Uma `StringIndexOutOfBoundsException` é lançada.)

📖 *is thrown* = é lançada
</details>

---

### Question 15

Given:

```java
public class Cache {
    public static void main(String[] args) {
        Integer a = 127, b = 127;
        Integer c = 128, d = 128;
        Long e = 127L;
        System.out.println((a == b) + " " + (c == d) + " " + e.equals(127) + " " + (c == 128));
    }
}
```

What is the output when the program runs with default JVM settings?

- A. `true true true true`
- B. `true false true true`
- C. `true false false true`
- D. `false false false true`
- E. Compilation fails.

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 15.** Qual é a saída quando o programa roda com as configurações padrão da JVM?

📖 *default settings* = configurações padrão · *autoboxing* = conversão automática de primitivo para wrapper
</details>

---

### Question 16

Given:

```java
public class Builder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdef");
        sb.insert(2, "-").delete(4, 6).reverse().append(sb.length()).setCharAt(0, 'Z');
        System.out.println(sb);
    }
}
```

What is the output?

- A. `Zc-ba6`
- B. `Zc-ba5`
- C. `fc-ba5`
- D. `Zc-ba7`
- E. Compilation fails because `setCharAt()` returns `void`.

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 16.** Qual é a saída? (E. A compilação falha porque `setCharAt()` retorna `void`.)

📖 *method chaining* = encadeamento de métodos · *returns* = retorna
</details>

---

### Question 17

Which two statements are true about running `java Hello.java` (source-file mode) with JDK 11? **(Choose two.)**

- A. The source file is compiled in memory and no `.class` file is written to disk.
- B. The file name must match the name of the public class declared in it.
- C. The file may declare more than one top-level class, and the first one declared is the one executed.
- D. Classes declared in other `.java` files in the same directory are compiled automatically when referenced.
- E. The class to execute is chosen by matching the file name, not by its position in the file.

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 17.** Quais duas afirmações são verdadeiras sobre executar `java Hello.java` (modo arquivo-fonte) com o JDK 11? **(Escolha duas.)**

- A. O arquivo-fonte é compilado em memória e nenhum arquivo `.class` é gravado em disco.
- B. O nome do arquivo deve ser igual ao nome da classe pública declarada nele.
- C. O arquivo pode declarar mais de uma classe de nível superior, e a primeira declarada é a executada.
- D. Classes declaradas em outros arquivos `.java` do mesmo diretório são compiladas automaticamente quando referenciadas.
- E. A classe a executar é escolhida pelo nome do arquivo, não pela posição dela no arquivo.

📖 *statements* = afirmações · *top-level class* = classe de nível superior (não aninhada) · *written to disk* = gravado em disco · *must match* = deve corresponder
</details>

---

### Question 18

Given:

```java
public class Casting {
    public static void main(String[] args) {
        long big = 3_000_000_000L;
        int i = (int) big;
        float f = big;
        double d = 0.1 + 0.2;
        System.out.print((i < 0) + " ");
        System.out.print((f == big) + " ");
        System.out.print((d == 0.3) + " ");
        System.out.print((int) 'A' + (char) 66);
    }
}
```

What is the output?

- A. `true false false 131`
- B. `true true false 65B`
- C. Compilation fails because of `float f = big;`
- D. `true true false 131`
- E. `false true false 131`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 18.** Qual é a saída? (C. A compilação falha por causa de `float f = big;`.)

📖 *widening* = alargamento (conversão para tipo "maior") · *narrowing* = estreitamento · *because of* = por causa de
</details>

---

### Question 19

Given:

```java
public class SbEquals {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("x");
        StringBuilder b = new StringBuilder("x");
        String s = "x";
        System.out.println(a.equals(b) + " " + s.equals(a) + " "
                + s.contentEquals(a) + " " + (a.compareTo(b) == 0));
    }
}
```

What is the output on Java 11?

- A. `true true true true`
- B. `false true true true`
- C. Compilation fails.
- D. `true false true true`
- E. `false false true true`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 19.** Qual é a saída no Java 11? (C. A compilação falha.)

📖 *content* = conteúdo · *equals* = igual (igualdade lógica) · *compareTo* = comparar (ordem)
</details>

---

### Question 20

Given:

```java
public class Zero {
    public static void main(String[] args) {
        int a = 5;
        double b = a / 0.0;
        double c = 0.0 / 0.0;
        System.out.print(b + " " + (c == c) + " " + Double.isNaN(c) + " ");
        System.out.print(a / 0);
    }
}
```

What is the result?

- A. `Infinity false true ` followed by an `ArithmeticException`
- B. An `ArithmeticException` is thrown before anything is printed.
- C. `Infinity true true ` followed by an `ArithmeticException`
- D. `Infinity false true Infinity`
- E. `NaN false true ` followed by an `ArithmeticException`

<details><summary>🇧🇷 Tradução e vocabulário</summary>

**Questão 20.** Qual é o resultado?

- A. `Infinity false true ` seguido de uma `ArithmeticException`
- B. Uma `ArithmeticException` é lançada antes de qualquer coisa ser impressa.
- C. `Infinity true true ` seguido de uma `ArithmeticException`
- D. `Infinity false true Infinity`
- E. `NaN false true ` seguido de uma `ArithmeticException`

📖 *before anything is printed* = antes de qualquer coisa ser impressa · *NaN* = *Not a Number*, "não é um número"
</details>

---

**Fim do simulado.** Preencha [`RESPOSTAS.md`](RESPOSTAS.md), faça o commit e peça a correção.
