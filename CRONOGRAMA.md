# Cronograma: de Java 8 ao Java 27 em 26 semanas

**Início:** segunda, 12/10/2026 · **Fim:** domingo, 11/04/2027 · **Carga:** ~10h/semana (~260h no total)

**Estratégia escolhida:** fechar todo o conteúdo da **1Z0-819 (Java 11)** até a semana 17. Depois, cobrir as diferenças do
**Java 17/21 (1Z0-830)** e as novidades até a **última versão estável (JDK 27, set/2026)**. A fase final é a ponte
para engenharia e arquitetura de software.

> **Sobre as provas.** Não consegui confirmar se a Oracle ainda oferece a 1Z0-819 em 2026. Antes do Marco 3 (semana 17),
> confira no [Oracle University](https://education.oracle.com/) quais provas estão ativas. Se a 1Z0-819 estiver
> descontinuada, nada se perde: o conteúdo das fases 1 a 4 é a base da 1Z0-830 (Java 21).

## Visão geral

```
Fase 1  Base revisitada        S01-S03  ███
Fase 2  OO avançada            S04-S06     ███  ◆ Marco 1: Simulado Geral 1
Fase 3  APIs essenciais        S07-S12        ██████  ◆ Marco 2: Simulado Geral 2
Fase 4  Plataforma Java        S13-S17              █████  ◆ Marco 3: Simulados Gerais 3 e 4 (pronto p/ 1Z0-819)
Fase 5  Java moderno 12→27     S18-S22                   █████  ◆ Marco 4: Simulado Geral 5 (formato 1Z0-830)
Fase 6  Especialista/arquitet. S23-S26                        ████  ◆ Marco 5: Simulado Final 6 + retrospectiva
```

## Rotina semanal padrão (10h)

| Dia | Atividade | Tempo |
|---|---|---|
| Seg | Guia do módulo: perguntas-guia respondidas com fontes oficiais (JLS/Javadoc/JEPs) | 1h30 |
| Ter | Exercícios de código | 2h |
| Qua | Exercícios de código + testes próprios | 2h |
| Qui | Análise de código (prever → executar → registrar) | 1h30 |
| Sex | Revisão espaçada: caderno de erros + glossário EN-PT | 1h |
| Sáb | Simulado do módulo (20 questões, 36 min) + pedido de correção | 1h30 |
| Dom | Leitura da correção, 2ª tentativa das erradas, atualização do caderno | 30min |

Nas **semanas de marco**, o sábado vira **Simulado Geral** (50 questões, 90 ou 120 min) e a sexta vira revisão dirigida.

## Cronograma detalhado

### Fase 1: Base da linguagem revisitada (sem ser maçante)

| Sem. | Datas | Módulo | Conteúdo | Versões |
|:---:|---|---|---|---|
| 1 | 12/10 a 18/10/26 | **M01** Tipos, operadores, `var`, wrappers e Strings | literais, promoção/casting, precedência, `var`, cache de wrappers, pool de Strings, API de String 11, `StringBuilder`, `main`, imports, arquivo-fonte único | 8, 10, 11 |
| 2 | 19/10 a 25/10/26 | **M02** Controle de fluxo e arrays | `if`/`switch` clássico (tipos permitidos, *fall-through*), laços, *labels*, `break`/`continue`, arrays multidimensionais, `Arrays` (`sort`, `binarySearch`, `compare`, `mismatch`) | 8, 9 |
| 3 | 26/10 a 01/11/26 | **M03** Classes e objetos | construtores, ordem de inicialização (estática, instância, construtor), `this`/`static`, passagem por valor, encapsulamento, imutabilidade, ciclo de vida e GC | 8, 11 |

### Fase 2: Orientação a objetos avançada

| Sem. | Datas | Módulo | Conteúdo | Versões |
|:---:|---|---|---|---|
| 4 | 02/11 a 08/11/26 | **M04** Herança e polimorfismo | sobrescrita × sobrecarga × ocultação, `super`, classes abstratas, casting de referências, `instanceof`, regras de modificadores e exceções na sobrescrita | 8 |
| 5 | 09/11 a 15/11/26 | **M05** Interfaces, enums e classes aninhadas | métodos `default`/`static`/`private` em interfaces, conflitos de herança múltipla, enums com corpo, classes internas/estáticas/locais/anônimas, `equals`/`hashCode`/`toString` | 8, 9 |
| 6 | 16/11 a 22/11/26 | **M06** Exceções | checked × unchecked, multi-catch, `finally`, try-with-resources (variável efetivamente final, Java 9), exceções suprimidas, hierarquia própria de exceções | 7, 9 |
| | **22/11** | ◆ **Marco 1: Simulado Geral 1** | 50 questões / 90 min sobre M01-M06 | |

### Fase 3: APIs essenciais

| Sem. | Datas | Módulo | Conteúdo | Versões |
|:---:|---|---|---|---|
| 7 | 23/11 a 29/11/26 | **M07** Generics | classes/métodos genéricos, limites, curingas (PECS), *type erasure*, tipos brutos, inferência com `<>` | 5, 7 |
| 8 | 30/11 a 06/12/26 | **M08** Collections | `List`/`Set`/`Map`/`Queue`/`Deque`, fábricas imutáveis (`List.of`, `copyOf`), `Comparable`/`Comparator` encadeado, `ConcurrentModificationException` | 8, 9, 10 |
| 9 | 07/12 a 13/12/26 | **M09** Lambdas e interfaces funcionais | `java.util.function`, especializações primitivas, *method references* (4 tipos), escopo e "efetivamente final", `var` em parâmetros de lambda | 8, 11 |
| 10 | 14/12 a 20/12/26 | **M10** Streams I | pipeline lazy, operações intermediárias e terminais, `Optional` (8 a 11), streams primitivos, `takeWhile`/`dropWhile`/`iterate` | 8, 9, 10, 11 |
| 11 | 21/12 a 27/12/26 | **M11** Streams II | `Collectors` (`groupingBy`, `partitioningBy`, `toMap`, `mapping`, `filtering`, `flatMapping`), `reduce`, streams paralelos e seus riscos | 8, 9 |
| 12 | 28/12/26 a 03/01/27 | **M12** Date/Time e localização | `java.time` (`LocalDate`, `ZonedDateTime`, `Duration`, `Period`, DST), `Locale`, `ResourceBundle`, `NumberFormat`, `DateTimeFormatter` | 8, 11 |
| | **03/01** | ◆ **Marco 2: Simulado Geral 2** | 50 questões / 90 min, com ênfase em M07-M12 | |

> As semanas 11 e 12 caem no Natal e no Ano-Novo. Se precisar, junte M11 e M12 numa semana só e use a outra como folga.
> **Nunca pule um simulado.**

### Fase 4: Plataforma Java

| Sem. | Datas | Módulo | Conteúdo | Versões |
|:---:|---|---|---|---|
| 13 | 04/01 a 10/01/27 | **M13** I/O e NIO.2 | `java.io` (streams de bytes/caracteres, *decorators*), serialização, `Console`, `Path`/`Files` (`walk`, `find`, `lines`, atributos), `Files.readString` | 7, 8, 11 |
| 14 | 11/01 a 17/01/27 | **M14** Concorrência I | threads, `ExecutorService`, `Callable`/`Future`, `synchronized`, `volatile`, atômicos, modelo de memória (*happens-before*) | 5, 8 |
| 15 | 18/01 a 24/01/27 | **M15** Concorrência II | `Lock`/`ReentrantReadWriteLock`, coleções concorrentes, `CyclicBarrier`/`CountDownLatch`, `CompletableFuture`, *deadlock*, *livelock*, *starvation*, *race condition* | 5, 8, 9 |
| 16 | 25/01 a 31/01/27 | **M16** Módulos (JPMS) | `module-info` (`requires transitive`, `exports ... to`, `opens`, `uses`/`provides`), módulos nomeados/automáticos/sem nome, migração *top-down*/*bottom-up*, `jdeps`, `jlink` | 9, 11 |
| 17 | 01/02 a 07/02/27 | **M17** JDBC, anotações e secure coding | `Connection`/`PreparedStatement`/`CallableStatement`/`ResultSet`, transações; anotações próprias (`@Retention`, `@Target`, `@Repeatable`); Secure Coding Guidelines (injeção, DoS, imutabilidade, dados sensíveis, serialização) | 8, 11 |
| | **06/02 e 07/02** | ◆ **Marco 3: Simulados Gerais 3 e 4** | dois simulados completos no formato 1Z0-819. **Meta: ≥ 80% nos dois.** Decisão: agendar a 1Z0-819 (se disponível) ou seguir para a 1Z0-830 | |

### Fase 5: Java moderno, do 12 ao 27

| Sem. | Datas | Módulo | Conteúdo | Versões |
|:---:|---|---|---|---|
| 18 | 08/02 a 14/02/27 | **M18** Sintaxe moderna | *switch expressions* e `yield`, *text blocks*, NPEs detalhados, `String.indent/transform/stripIndent`, `Stream.toList`, `mapMulti`, `Collectors.teeing` | 12 a 17 |
| 19 | 15/02 a 21/02/27 | **M19** Records e sealed classes | construtores compactos, records aninhados/locais, `sealed`/`permits`/`non-sealed`, modelagem de domínio com tipos algébricos | 16, 17 |
| 20 | 22/02 a 28/02/27 | **M20** Pattern matching | `instanceof` com padrão, `switch` com padrões e *guards* (`when`), *record patterns*, exaustividade, variáveis sem nome `_` | 16, 21, 22 |
| 21 | 01/03 a 07/03/27 | **M21** Concorrência moderna e coleções sequenciadas | *virtual threads*, `Executors.newVirtualThreadPerTaskExecutor`, *pinning*, `SequencedCollection`/`SequencedMap`, *stream gatherers* (24), *scoped values* (25) | 21, 24, 25 |
| 22 | 08/03 a 14/03/27 | **M22** Java 25 LTS e Java 27 | corpos de construtor flexíveis, `import module`, arquivos-fonte compactos e `main` de instância (25); *structured concurrency*, *primitive patterns* e *lazy constants* (em preview no 27); G1 padrão e *compact object headers* (27) | 25, 27 |
| | **14/03** | ◆ **Marco 4: Simulado Geral 5** | formato **1Z0-830** (50 questões / 120 min), cobrindo todo o conteúdo do Java 21 | |

### Fase 6: Especialista e ponte para arquitetura

| Sem. | Datas | Módulo | Conteúdo |
|:---:|---|---|---|
| 23 | 15/03 a 21/03/27 | **M23** JVM por dentro | heap/stack/metaspace, coletores (G1, ZGC), JIT, *escape analysis*, JFR e `jcmd`: diagnosticar um vazamento e um gargalo reais |
| 24 | 22/03 a 28/03/27 | **M24** Projeto integrador I | domínio rico com **DDD tático** + **Clean Architecture** em Java 21+, sem framework: *value objects* com records, agregados, eventos de domínio, *sealed results*. Revisão com as skills `java-architect` e `java-dev` |
| 25 | 29/03 a 04/04/27 | **M25** Projeto integrador II | testes como especialista (JUnit 5, testes de propriedade, *test doubles*), padrões de projeto aplicados, **revisão de código como arquiteto** (você revisa um código "legado" que eu preparo) |
| 26 | 05/04 a 11/04/27 | **Fechamento** | ◆ **Marco 5: Simulado Final 6** (1Z0-819 ou 1Z0-830, conforme a decisão do Marco 3), retrospectiva e plano dos próximos 6 meses (Spring Boot 3, microsserviços, arquitetura de soluções) |

## Critérios para avançar

| Situação | Ação |
|---|---|
| Módulo com nota ≥ 70 **e** simulado ≥ 68% | Segue para o próximo módulo |
| Simulado < 68% | Revisão dirigida no domingo e **Simulado B** do mesmo tema (questões novas) antes de avançar |
| Simulado Geral < 75% | A semana seguinte começa com 3h de revisão dos temas mais fracos (o tutor indica quais, a partir dos erros) |
| Atraso de 1 semana | Corte primeiro o desafio opcional dos módulos; depois condense o M23. **Nunca pule simulado** |

## Como os módulos são liberados

Os módulos são criados **um de cada vez**, quando você conclui o anterior. Assim a dificuldade se ajusta aos seus
erros: os temas em que você errou voltam como pegadinhas nos módulos seguintes (revisão espaçada embutida).
Para liberar o próximo, peça: **"crie o módulo M02"**.
