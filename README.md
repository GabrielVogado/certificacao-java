# Certificação Java: de Java 8 ao Java 27

Treino técnico para a certificação **Oracle Java SE 11 Developer (1Z0-819)**, com extensão para
**Java SE 21 Developer (1Z0-830)** e as novidades até o **JDK 27**. O objetivo final é chegar ao **nível
especialista** em 6 meses e preparar o caminho para engenharia e arquitetura de software.

## Por onde começar

1. Leia o [mapa mental](MAPA-MENTAL.md) (ou abra o `mapa-mental.html` no navegador) para ver tudo o que a prova cobra.
2. Siga o [cronograma](CRONOGRAMA.md): a semana 1 é o módulo [M01](modulos/m01-tipos-operadores-strings/README.md).

## A regra de ouro

> **O tutor (IA) nunca entrega respostas**: nem código de solução, nem alternativa correta, nem saída de
> programa. Ele explica **como chegar à solução**, aponta o conceito e a fonte oficial, e corrige de forma
> explicativa. Quem resolve é você.

Essa regra está gravada em [`CLAUDE.md`](CLAUDE.md) e é carregada automaticamente em toda sessão do Claude Code
neste projeto.

## Estrutura

```
certificacao-java/
├── README.md               ← você está aqui
├── CLAUDE.md               ← regras do modo tutor (lidas pelo Claude Code)
├── .claude/skills/java-dev ← padrão de código usado nas correções
├── CRONOGRAMA.md           ← 26 semanas, fases, marcos e datas
├── MAPA-MENTAL.md          ← mapa dos assuntos da prova (base Java 8) com perguntas-guia
├── mapa-mental.html        ← versão interativa do mapa (abra no navegador)
├── AVALIACAO.md            ← como as notas são calculadas (padrão Oracle: 68%, sem crédito parcial)
├── PROGRESSO.md            ← painel de notas (o tutor atualiza)
├── CADERNO-DE-ERROS.md     ← suas regras escritas com suas palavras (só você escreve)
├── GLOSSARIO.md            ← vocabulário EN → PT da prova
├── pom.xml                 ← POM agregador (JUnit 5)
└── modulos/
    └── m01-tipos-operadores-strings/
        ├── README.md           ← guia: objetivos, roteiro, perguntas-guia, fontes oficiais, checklist
        ├── EXERCICIOS.md       ← enunciados dos exercícios de código
        ├── pom.xml             ← --release 11 (o compilador recusa APIs mais novas)
        ├── src/main/java/...   ← onde você implementa
        ├── src/test/java/...   ← testes = especificação executável (não altere)
        ├── analise/            ← trechos para prever a saída / se compila
        └── simulado/
            ├── SIMULADO.md     ← 20 questões em inglês com tradução 🇧🇷 recolhível
            └── RESPOSTAS.md    ← sua folha de respostas
```

## Pré-requisitos

- **JDK 21 ou superior** para as fases 1 a 4. Os módulos compilam com `--release 11`, então um JDK novo
  serve e ainda impede o uso de APIs posteriores ao Java 11.
- **JDK 25 (LTS)** a partir da semana 18 e **JDK 27** para o M22.
- **Maven 3.9+**.

```bash
cd modulos/m01-tipos-operadores-strings
mvn test                          # todos os testes do módulo (começam falhando, de propósito)
mvn test -Dtest=TextosTest        # um exercício
java --source 11 analise/A01_Overflow.java   # análise de código (depois de prever!)
```

## Fluxo de cada módulo

1. **Guia** (`README.md` do módulo): responda às perguntas-guia **consultando só fontes oficiais**.
2. **Exercícios** (`EXERCICIOS.md`): implemente até os testes passarem, respeitando as restrições, e escreva testes próprios.
3. **Análise de código** (`analise/`): preveja, execute, registre e copie os erros para o caderno.
4. **Simulado** (`simulado/`): 36 minutos, sem consulta e sem executar nada. Preencha `RESPOSTAS.md`.
5. **Peça a correção** numa sessão do Claude Code neste repositório:
   - `corrija o simulado do M01`
   - `corrija os exercícios do M01`
   - `quero uma dica nível 2 no exercício 1.2` (custa pontos; veja [AVALIACAO.md](AVALIACAO.md))
6. **Caderno de erros**: escreva as regras que errou, com suas palavras.
7. **Próximo módulo**: `crie o módulo M02`. Os módulos são gerados um a um e calibrados pelos seus erros.

## Skills usadas como padrão de qualidade

| Skill | Onde fica | Uso na trilha |
|---|---|---|
| `java-dev` | [`.claude/skills/java-dev/`](.claude/skills/java-dev/SKILL.md) | Padrão de código: nomes, exceções, null/Optional, testes, performance (Google Java Style + Manual Alibaba) |
| `java-architect` | skill da organização | Arquitetura (DDD, Clean Architecture, Java 21) na Fase 6; validação de entrada e hierarquia de exceções desde o M01 |
| `java` | skill da organização | Boas práticas de Java moderno (records, sealed, Optional, genéricos sem tipo bruto) |
