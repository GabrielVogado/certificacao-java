# Critérios de avaliação

As notas seguem a lógica das certificações oficiais da Oracle: **percentual de acertos**, **sem crédito parcial**
e **nota de corte de 68%**. Para os exercícios de código, que não existem na prova, a rubrica usa os padrões das
skills `java-architect` e `java-dev`.

## 1. Referência: provas oficiais

| Prova | Conteúdo | Questões | Tempo | Corte |
|---|---|:---:|:---:|:---:|
| **1Z0-819**: Java SE 11 Developer | Java 11 | 50 | 90 min | 68% |
| **1Z0-829**: Java SE 17 Developer | Java 17 | 50 | 90 min | 68% |
| **1Z0-830**: Java SE 21 Developer | Java 21 | 50 | 120 min | 68% |

> Valores publicados pela Oracle até a minha última verificação. A Oracle muda formatos e descontinua provas,
> então **confirme no site oficial antes de agendar**.

Características que reproduzimos nos simulados:

- Questões de **resposta única** e de **múltipla resposta** (*"Choose two/three"*). Nas de múltipla resposta, só conta acerto quem marcar **todas** as alternativas corretas e nenhuma errada.
- Não há penalidade por chute: nunca deixe questão em branco.
- Muitas questões têm "Compilation fails" ou "An exception is thrown" entre as alternativas. Saber **quando o código não compila** vale tanto quanto saber o que ele imprime.

## 2. Simulados

### Tipos

| Tipo | Quando | Questões | Tempo |
|---|---|:---:|:---:|
| Simulado de módulo | todo sábado | 20 | 36 min |
| Simulado B (recuperação) | quando o de módulo fica < 68% | 20 (novas) | 36 min |
| Simulado Geral (formato 1Z0-819) | Marcos 1, 2 e 3 | 50 | 90 min |
| Simulado Geral (formato 1Z0-830) | Marco 4 | 50 | 120 min |

### Nota

```
nota (%) = acertos / total de questões × 100
```

| Faixa | Conceito | Significado |
|:---:|---|---|
| 90–100% | **A: Especialista** | Domínio pleno; você explicaria cada pegadinha para outra pessoa |
| 80–89% | **B: Aprovado com folga** | Margem de segurança para o dia da prova |
| 68–79% | **C: Aprovado** | Passaria, mas com risco; revise os erros |
| 50–67% | **D: Reprovado (perto)** | Revisão dirigida + Simulado B |
| 0–49% | **E: Reprovado** | Refazer o guia do módulo antes do Simulado B |

**Meta interna:** ≥ 80% nos simulados gerais antes de agendar uma prova real. O nervosismo e o enunciado em
inglês costumam custar alguns pontos no dia da prova.

### Indicadores complementares (não entram na nota)

- **Erro de conceito:** errou com confiança 3. É a prioridade máxima no caderno de erros, porque você *acha* que sabe.
- **Acerto frágil:** acertou com confiança 1. Conta ponto, mas o tema volta na revisão.
- **Dependência de tradução:** % de questões em que você abriu o bloco 🇧🇷. A meta é chegar a < 20% até o Marco 3 e a 0% no Marco 4.
- **Ritmo:** tempo usado ÷ tempo disponível. Acima de 100% é reprovação no dia da prova, mesmo sabendo o conteúdo.

## 3. Exercícios de código (100 pontos)

| Critério | Pontos | O que é avaliado |
|---|:---:|---|
| **Correção funcional** | 40 | Testes fornecidos passando (proporcional ao número de testes verdes) |
| **Domínio da linguagem** | 20 | Uso correto e idiomático dos recursos da versão-alvo; **restrições do enunciado respeitadas** (cada violação: −10) |
| **Qualidade e padrões** | 20 | Skill `java-dev` (nomes, ordem dos membros, imports sem curinga, exceções específicas e com mensagem útil, sem *magic numbers*, Javadoc em API pública) e skill `java` (sem tipos brutos, nada de `Optional.get()` sem checagem, imutabilidade) |
| **Robustez e segurança** | 10 | Validação de entrada, casos de borda, nenhum dado sensível em mensagens ou logs (skill `java-architect`: *never skip input validation*) |
| **Testes próprios** | 10 | Casos de borda relevantes que **você** escreveu em `MeusTestesM01Test` (ou equivalente), no padrão Given-When-Then |

O conceito final usa as mesmas faixas dos simulados (A a E).

### Custo das dicas

| Nível | O que você recebe | Custo |
|---|---|:---:|
| 1 | Pergunta conceitual que aponta **onde** pensar (já vem nos enunciados) | 0 |
| 2 | Qual conceito ou API investigar e qual seção da JLS/Javadoc ler | −3 |
| 3 | Estratégia em passos, em português, **sem código** | −7 |

O tutor **nunca** entrega código de solução, alternativa correta ou saída esperada, nem mesmo como dica de nível 3.

## 4. Nota do módulo

```
nota do módulo = 0,6 × simulado + 0,4 × exercícios
```

O módulo está **aprovado** com nota ≥ 70 **e** simulado ≥ 68%. A análise de código é autoavaliada e serve como
termômetro: registre o total em [PROGRESSO.md](PROGRESSO.md), mas ele não entra na nota.

## 5. Como a correção é feita (transparência)

- **Simulados:** o tutor determina a resposta de cada questão **compilando e executando o código** com o JDK e a
  `--release` do módulo, fora do repositório. O gabarito nunca é gravado no repositório.
- **Correção sem entregar a resposta:** em cada questão errada você recebe ❌, o **conceito testado**, o **motivo
  pelo qual a sua alternativa falha**, perguntas-guia e a referência oficial. A alternativa correta **não é
  revelada**. Depois de receber a correção você pode refazer as questões erradas (2ª tentativa, que não altera a
  nota) e, só então, executar o código para confirmar.
- **Exercícios:** o tutor roda `mvn test`, lê o código e comenta por arquivo e linha. Ele aponta **o problema e o
  princípio violado**, nunca o código corrigido.
