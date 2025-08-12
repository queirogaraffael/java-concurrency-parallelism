
# Java Multithreading: Exercícios de Concorrência e Paralelismo

Este repositório reúne uma coleção de exercícios práticos em Java para aprofundar o aprendizado em concorrência e paralelismo. Os exemplos abrangem desde conceitos fundamentais de threads até recursos avançados, como `CompletableFuture` e `parallel streams`, baseados em anotações de um curso especializado.

O projeto foi desenvolvido utilizando **Java 8**.

Para consultar minhas anotações completas sobre o tema, acesse o link no Notion:  
[Anotações de Paralelismo e Concorrência](https://raffaelqueiroga.notion.site/Paralelismo-Concorr-ncia-1b74a077442a80adbfe3ce051f7415ef?source=copy_link)

---

## Estrutura do Projeto

O projeto está organizado em pacotes temáticos, cada um focado em um aspecto específico da programação concorrente em Java:

### 1. Fundamentos (`topic1_fundamentals`)

Exercícios básicos sobre criação e controle de threads.

- **ContadorRunnable.java** — Implementação de `Runnable` que conta de 1 a 10.
- **MainLambda.java** — Demonstra o uso de expressões lambda para criação concisa de threads.
- **MainMultiThread.java** — Criação e sincronização de múltiplas threads com uso de `join()`.

### 2. Sincronização (`topic2_synchronization`)

Estudo de condições de corrida e técnicas para evitá-las.

- **ContadorSincronizado.java** — Uso da palavra-chave `synchronized` para evitar condições de corrida.
- **ContadorComLock.java** — Controle de concorrência com `ReentrantLock` e o cuidado com o bloco `finally`.
- **SimuladorDeadlock.java** — Exemplo intencional de deadlock para compreensão do problema.

### 3. Executor Framework (`topic3_executors`)

Gerenciamento de threads com o framework Executor.

- **Exercicio31CallableFuture.java** — Execução assíncrona com `Callable` e `Future`.
- **Exercicio32InvokeAll.java** — Submissão de múltiplas tarefas com `invokeAll()` e processamento coletivo.
- **Exercicio33Agendador.java** — Agendamento periódico de tarefas via `ScheduledExecutorService`.

### 4. Sincronizadores Avançados (`topic4_synchronizers`)

Ferramentas de sincronização para controle refinado de threads.

- **Corrida.java** — Uso de `CountDownLatch` para coordenar início simultâneo de threads.
- **Estacionamento.java** — Simulação de acesso limitado a recursos usando `Semaphore`.
- **FasesDoProjeto.java** — Sincronização em fases com `CyclicBarrier`.

### 5. Produtor-Consumidor (`topic5_producerconsumer`)

Implementação do padrão clássico produtor-consumidor.

- **ArmazemBlockingQueue.java** — Produtor-consumidor com `LinkedBlockingQueue` de capacidade limitada.
- **ArmazemSynchronousQueue.java** — Uso de `SynchronousQueue` com bloqueio até o consumo do item.

### 6. Programação Assíncrona (`topic6_async`)

Manipulação de fluxos assíncronos com `CompletableFuture`.

- **CadeiaDeOperacoes.java** — Sequência de operações assíncronas com `thenApply` e `thenAccept`.
- **CombinandoFutures.java** — Combinação paralela de resultados com `thenCombine`.

### 7. Paralelismo com Streams (`topic7_parallelism`)

Comparação e aplicação de streams sequenciais e paralelos.

- **AnaliseDePerformance.java** — Avaliação de performance entre streams sequenciais e paralelos em operações intensivas.
- **SomaComStreamsParalelos.java** — Solução eficiente para soma em arrays grandes usando `parallel()`.

---

## Como Executar

Para rodar os exercícios:

1. Clone este repositório:

   ```bash
   git clone https://github.com/queirogaraffael/java-concurrency-parallelism
   ```

2. Abra o projeto na sua IDE Java preferida (IntelliJ IDEA, Eclipse, VSCode, etc).

3. Navegue até a classe `main` do exercício desejado.

4. Execute a classe como uma aplicação Java.

---

## Requisitos

- Java 8
- IDE com suporte a projetos Maven

---

**Bom estudo e bons códigos! 🚀**
