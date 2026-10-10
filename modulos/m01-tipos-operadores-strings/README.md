# M01: Tipos de dados, operadores, `var`, wrappers e Strings

**Semana 1** · **Fase 1: Base da linguagem revisitada** · Versão-alvo: **Java 11** (escopo da 1Z0-819)

> Você já programa em Java há 10 anos, então este módulo **não ensina o básico**: ele caça as **arestas**
> do básico. A prova não pergunta "o que é um `int`", e sim "o que acontece com este `int` nesta linha".
> Cada atividade foi pensada para expor uma regra que o dia a dia com IDE e frameworks esconde.

## Objetivos da prova cobertos

Objetivos da **1Z0-819**, com a redação resumida:

- *Working with Java Data Types*: tipos primitivos, wrappers, autoboxing, promoção e casting; `var`.
- *Working with Java Data Types*: manipulação de `String` e `StringBuilder`.
- *Java Fundamentals*: operadores, precedência, avaliação de expressões e efeitos colaterais.
- *Java Fundamentals*: estrutura de uma classe, `main`, pacotes e imports; modo arquivo-fonte (`java Arquivo.java`).

Novidades de versão que aparecem aqui: `var` (Java 10), `var` em parâmetros de lambda (11), `String.strip/isBlank/lines/repeat` (11),
`StringBuilder.compareTo` (11), execução de arquivo-fonte único (11, JEP 330).

## Roteiro da semana (≈ 10h)

| Dia | Atividade | Tempo |
|---|---|---|
| Seg | Responder as **perguntas-guia** abaixo usando **apenas as fontes oficiais** | 1h30 |
| Ter | [Exercícios](EXERCICIOS.md) 1 e 2 | 2h |
| Qua | [Exercício](EXERCICIOS.md) 3 e testes próprios | 2h |
| Qui | [Análise de código](analise/ANALISE.md): A01 a A08 (prever → executar → registrar) | 1h30 |
| Sex | Revisão: [Caderno de erros](../../CADERNO-DE-ERROS.md) e [Glossário EN-PT](../../GLOSSARIO.md) | 1h |
| Sáb | [**Simulado**](simulado/SIMULADO.md) (36 min) + pedir correção | 1h30 |
| Dom | Ler a correção, refazer as questões erradas e atualizar o caderno de erros | 30min |

## Perguntas-guia

Responda **por escrito** (num arquivo seu ou no caderno) **antes** dos exercícios. Se não souber responder
com segurança, vá à fonte indicada. As respostas não estão em lugar nenhum deste repositório: o objetivo é
você construí-las.

**Literais e identificadores**

1. Onde **não** se pode colocar `_` dentro de um literal numérico? Liste todas as posições proibidas.
2. Que tipo tem o literal `2147483648`? E `017`? E `0b11`? O que acontece com `09`?
3. Por que `var` pode ser nome de variável, mas `_` não pode (desde o Java 9)? Qual a diferença entre *keyword* e *reserved type name*?

**Primitivos, conversões e promoção**

4. Quais conversões de alargamento (*widening*) podem **perder precisão** mesmo sendo implícitas?
5. Quando o compilador aceita `byte b = 10;` sem cast, mas recusa `byte b = i;` com `int i = 10;`? Qual o papel de uma **constante em tempo de compilação**?
6. Por que `b += 300` compila e `b = b + 300` não compila, sendo `b` um `byte`?
7. Quais são as regras de **promoção numérica binária**? O que acontece com `short + short`?
8. Qual é o sinal do resto em `%`? E o que acontece em `Integer.MIN_VALUE / -1`?
9. Divisão por zero: quando lança exceção e quando resulta em `Infinity`/`NaN`?

**`var`**

10. Liste todos os lugares onde `var` **não** pode ser usado. Por que `var x = null;` não compila?

**Operadores**

11. Monte de memória a tabela de precedência, de `++`/`--` pós-fixos até a atribuição. Onde ficam `&`, `^` e `|` em relação a `&&` e `||`?
12. Em que ordem a JVM avalia os operandos de `a() + b() * c()`? Precedência é a mesma coisa que ordem de avaliação?
13. Qual é o **tipo** de uma expressão ternária quando os operandos são `int` e `double`? E `Integer` e `int`?

**Wrappers**

14. Qual faixa de valores é **garantida** pelo cache de `Integer.valueOf`? Onde isso está especificado?
15. `Long.valueOf(10).equals(10)` retorna o quê, e por quê?

**String e StringBuilder**

16. Quando duas `String` montadas com `+` apontam para o mesmo objeto do pool?
17. `trim()` × `strip()`, `isEmpty()` × `isBlank()`: qual é a diferença **exata** segundo o Javadoc?
18. Quais métodos de `StringBuilder` têm o mesmo nome que métodos de `String`, mas comportamento diferente (pense em `equals`)?
19. Em `sb.metodoA().metodoB(sb.length())`, quando `sb.length()` é avaliado?

**Estrutura e execução**

20. Quais assinaturas de `main` a JVM aceita como ponto de entrada no Java 11? E o que muda no Java 25?
21. Como se resolve o conflito entre dois imports curinga que trazem classes de mesmo nome? Que tipo de import "vence"?
22. No modo arquivo-fonte (`java Arquivo.java`), qual classe é executada? Algo é gravado em disco?

## Fontes oficiais (use estas, não blogs)

- JLS 11, [cap. 3: Estrutura léxica](https://docs.oracle.com/javase/specs/jls/se11/html/jls-3.html): §3.8 identificadores, §3.9 palavras-chave, §3.10 literais
- JLS 11, [cap. 4: Tipos e valores](https://docs.oracle.com/javase/specs/jls/se11/html/jls-4.html): §4.2 primitivos, §4.12.5 valores iniciais
- JLS 11, [cap. 5: Conversões](https://docs.oracle.com/javase/specs/jls/se11/html/jls-5.html): §5.1.2, §5.1.3, §5.2, §5.6
- JLS 11, [cap. 14: Declarações locais e `var`](https://docs.oracle.com/javase/specs/jls/se11/html/jls-14.html#jls-14.4)
- JLS 11, [cap. 15: Expressões](https://docs.oracle.com/javase/specs/jls/se11/html/jls-15.html): §15.7 ordem de avaliação, §15.25 ternário, §15.26.2 atribuição composta, §15.28 constantes
- JLS 11, [cap. 16: Atribuição definida](https://docs.oracle.com/javase/specs/jls/se11/html/jls-16.html)
- Javadoc 11: [`String`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html), [`StringBuilder`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/StringBuilder.html), [`Integer`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Integer.html), [`Character`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html), [`BigDecimal`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigDecimal.html)
- [JEP 286 (`var`)](https://openjdk.org/jeps/286) · [JEP 323 (`var` em lambdas)](https://openjdk.org/jeps/323) · [JEP 330 (arquivo-fonte único)](https://openjdk.org/jeps/330)
- [Secure Coding Guidelines for Java SE](https://www.oracle.com/java/technologies/javase/seccodeguide.html) (usado no exercício 3.3)

## Checklist de saída do módulo

Marque só o que você consegue **explicar em voz alta, sem consultar**:

- [ ] Regras de `_` em literais e os tipos de cada literal
- [ ] Promoção numérica, atribuição composta e constantes de compilação
- [ ] Todas as restrições do `var`
- [ ] Precedência completa e ordem de avaliação (pré/pós-incremento em expressões)
- [ ] Curto-circuito × operadores lógicos de bits
- [ ] Tipo de uma expressão ternária e o NPE do unboxing
- [ ] Cache de wrappers e `equals` entre wrappers diferentes
- [ ] Pool de Strings e o que é constante em tempo de compilação
- [ ] `trim` × `strip`, `isEmpty` × `isBlank`, `lines`, `repeat`
- [ ] `StringBuilder`: mutabilidade, encadeamento, `equals` e `compareTo`
- [ ] `main`, imports e modo arquivo-fonte

## Entregas

| Entrega | Arquivo | Como pedir correção |
|---|---|---|
| Exercícios de código | `src/main/java/...` + `MeusTestesM01Test` | "corrija os exercícios do M01" |
| Análise de código | [`analise/ANALISE.md`](analise/ANALISE.md) | autoavaliação (registre o total em PROGRESSO) |
| Simulado | [`simulado/RESPOSTAS.md`](simulado/RESPOSTAS.md) | "corrija o simulado do M01" |
