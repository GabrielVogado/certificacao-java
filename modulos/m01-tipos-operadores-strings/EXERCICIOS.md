# M01: Exercícios de código

> **Como trabalhar**
>
> - Implemente nos arquivos de `src/main/java/br/com/certificacao/m01/`. Os métodos começam lançando `UnsupportedOperationException`.
> - Rode os testes **dentro desta pasta**: `mvn test` (todos) ou `mvn test -Dtest=TextosTest` (um só).
> - **Não altere os testes fornecidos.** Eles são a especificação. Você **pode e deve** criar seus próprios testes em `src/test/java/br/com/certificacao/m01/MeusTestesM01Test.java`.
> - As **restrições** fazem parte do enunciado. Testes verdes com restrição violada perdem pontos na correção.
> - O módulo compila com `--release 11`: APIs posteriores ao Java 11 (ex.: `Stream.toList()`) não compilam aqui, de propósito.
> - Critérios de nota: [AVALIACAO.md](../../AVALIACAO.md). As dicas de **nível 1** abaixo são gratuitas; níveis 2 e 3 você pede ao tutor e elas custam pontos.

---

## Exercício 1: `AritmeticaSegura` (≈ 1h)

**Contexto.** Um módulo financeiro legado soma valores em centavos usando `int`. Um bug de overflow
gerou um saldo negativo em produção. Você vai escrever as operações primitivas seguras.

### 1.1 `somarExato(int a, int b)`

- Retorna `a + b` quando o resultado matemático cabe em `int`.
- Lança `ArithmeticException` quando não cabe (overflow positivo ou negativo).
- **Restrições:** proibido usar `long`, `Math.addExact` (ou qualquer `Math.*Exact`), `BigInteger` e `BigDecimal`.
  Também é proibido usar `try/catch` como lógica.

<details><summary>Dica nível 1 (gratuita)</summary>

Em complemento de dois, o que acontece com o **sinal** do resultado quando uma soma estoura?
Existe alguma combinação de sinais de `a` e `b` em que o overflow é **impossível**?
</details>

### 1.2 `mediaPiso(int a, int b)`

- Retorna `⌊(a + b) / 2⌋` calculado sobre os inteiros matemáticos, para **qualquer** par de `int`.
  Exemplos: `mediaPiso(-3, 4) == 0`, `mediaPiso(3, -4) == -1`, `mediaPiso(MAX, MAX) == MAX`.
- **Restrições:** proibido usar `long`, `double`, `float`, `BigInteger` e `BigDecimal`.

<details><summary>Dica nível 1 (gratuita)</summary>

Há **dois** problemas escondidos em `(a + b) / 2`: um de **capacidade** e outro de **arredondamento**
(para que lado `/` arredonda números negativos?). Resolva um de cada vez.
Os operadores de bits (`&`, `|`, `^`, `>>`, `>>>`) fazem parte do objetivo "operadores" da prova.
</details>

### 1.3 `paraByteSaturado(int valor)`

- Valores acima de `127` viram `127`; abaixo de `-128` viram `-128`; os demais são convertidos normalmente.
- **Restrição:** nada de números mágicos (`127`, `-128`). Use o que a API dos wrappers oferece.

<details><summary>Dica nível 1 (gratuita)</summary>

O que o cast `(byte) 200` produz, e **por quê**? Saber explicar isso é exatamente o que a prova cobra.
</details>

---

## Exercício 2: `ComparadorNumerico` (≈ 1h30)

**Contexto.** Um serviço de conciliação recebe o mesmo valor por três fontes: a API (JSON → `Double`), o
banco de dados (`BigDecimal`) e um sistema legado (`Long`). Hoje a comparação é feita com `equals` e
quase nada "bate". Escreva `mesmoValor(Number a, Number b)`.

**Regras de negócio:**

1. Tipos suportados: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `BigInteger`, `BigDecimal`.
   `null` ou qualquer outro tipo (ex.: `AtomicInteger`) → `IllegalArgumentException`.
2. Retorna `true` somente se os dois representam **exatamente o mesmo valor matemático**:
   - `Integer 1` e `Long 1` → `true`;
   - `BigDecimal "1.00"` e `Integer 1` → `true`;
   - `Float 0.1f` e `Double 0.1` → `false`;
   - `Long 9_007_199_254_740_993` e `Double 9_007_199_254_740_992.0` → `false`.
3. Casos especiais de ponto flutuante:
   - qualquer `NaN` (de `Float` ou `Double`) é igual a qualquer outro `NaN`, e a nada mais;
   - `+∞` só é igual a `+∞` (de `Float` ou `Double`); o mesmo vale para `-∞`;
   - `0.0`, `-0.0` e `0` são iguais.
4. A relação deve ser **simétrica**: `mesmoValor(a, b) == mesmoValor(b, a)`.

**Restrições:** não compare representações em `String` (`toString()`, `String.valueOf` etc.).

<details><summary>Dica nível 1 (gratuita)</summary>

Antes de escrever código, responda no papel: quantos bits de **mantissa** tem um `double`? Todo `long` cabe
**exatamente** em um `double`? E todo `float`? E todo `double` em um `BigDecimal`? Qual é a diferença entre
`BigDecimal.equals` e `BigDecimal.compareTo`?
</details>

---

## Exercício 3: `Textos` (≈ 1h30)

### 3.1 `normalizarEspacos(String texto)`

- Remove os espaços em branco das extremidades e reduz cada sequência **interna** de espaços em branco a um único `' '` (U+0020).
- "Espaço em branco" = qualquer caractere para o qual `Character.isWhitespace` retorna `true`.
  Isso inclui o EM SPACE (U+2003), mas **não** o NO-BREAK SPACE (U+00A0), que deve ser preservado.
- `null` → `IllegalArgumentException`.
- **Restrições:** sem expressões regulares (`split`, `replaceAll`, `replaceFirst`, `matches`, `Pattern`). Use um único `StringBuilder`.

<details><summary>Dica nível 1 (gratuita)</summary>

Qual é a diferença **documentada** entre `trim()` e `strip()`? Leia o Javadoc dos dois no Java 11 e compare
a definição de "espaço" que cada um usa.
</details>

### 3.2 `contarLinhasUteis(String texto)`

- Conta as linhas que **não** estão em branco e que **não** são comentários.
- Comentário = linha cujo primeiro caractere que não é espaço em branco é `#`.
- Terminadores de linha: `\n`, `\r` e `\r\n`.
- `null` → `IllegalArgumentException`.
- **Restrições:** sem regex e sem laço manual percorrendo caracteres. A ideia é usar a API de `String` que chegou no Java 11.

### 3.3 `mascararCartao(String numero)`

- Aceita apenas dígitos ASCII `0`–`9`, espaço e hífen. Qualquer outro caractere → `IllegalArgumentException`.
- A quantidade de dígitos deve ficar entre **13 e 19**; fora disso → `IllegalArgumentException`. `null` → `IllegalArgumentException`.
- Retorna só os dígitos, com todos menos os 4 últimos trocados por `*`: `"4111 1111 1111 1234"` → `"************1234"`.
- **Segurança:** a mensagem de qualquer exceção **não pode conter** nenhum trecho do número
  (Oracle *Secure Coding Guidelines for Java SE*, diretriz **CONFIDENTIAL-1**: *Purge sensitive information from exceptions*).

<details><summary>Dica nível 1 (gratuita)</summary>

`Character.isDigit('４')` (dígito "largo" japonês, U+FF14) retorna o quê? Leia o Javadoc de `Character.isDigit`
e pense em validação de entrada: lista de permitidos ou lista de proibidos?
</details>

### 3.4 `compactar(String texto)`

- *Run-length encoding*: cada sequência de caracteres iguais vira o caractere seguido da contagem;
  a contagem é omitida quando é 1. `"aaabccdddd"` → `"a3bc2d4"`.
- Entrada contendo dígitos → `IllegalArgumentException` (a saída seria ambígua). `null` → `IllegalArgumentException`.
- **Restrições:** uma única passada pela string, um único `StringBuilder`, sem regex.

---

## Desafio de especialista (opcional, vale até +10 no critério "testes próprios")

1. Em `MeusTestesM01Test`, escreva **pelo menos 5 casos de borda** que os testes fornecidos **não** cobrem.
2. No Javadoc de `mediaPiso`, explique **por que** a sua solução funciona para todos os 2⁶⁴ pares de entrada.
   Explicar a própria solução é o que se espera de um especialista numa revisão de código.

## Entrega

Faça o commit e peça ao tutor: **"corrija os exercícios do M01"**.
