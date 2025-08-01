package org.example.topic3_executors;

/**
 * Exercícios do Tópico 3: Executor Framework e Future
 *
 * Você pode resolver todos os exercícios deste tópico em uma única classe `GerenciadorDeTarefas`.
 *
 * -----
 *
 * Exercício 3.1 (Callable e Future):
 * Objetivo: Criar uma tarefa que retorna um valor e obtê-lo de forma assíncrona.
 * Passos:
 * 1. Crie uma tarefa (`Callable<Integer>`) que calcula o fatorial de um número (ex: 10).
 * Lembre-se que o fatorial de n é n * (n-1) * ... * 1.
 * 2. Crie um `ExecutorService` com `Executors.newSingleThreadExecutor()`.
 * 3. Submeta a tarefa ao executor usando `submit()`, que retornará um `Future<Integer>`.
 * 4. Chame o método `get()` no futuro para obter o resultado e imprima-o.
 * 5. Lembre-se de desligar o executor (`executor.shutdown()`).
 *
 * -----
 *
 * Exercício 3.2 (InvokeAll):
 * Objetivo: Executar um lote de tarefas e coletar todos os resultados.
 * Passos:
 * 1. Crie uma lista de `Callable<Integer>`. Adicione 5 tarefas de cálculo de fatorial nela.
 * 2. Crie um `ExecutorService` com `Executors.newFixedThreadPool(3)`.
 * 3. Use `invokeAll()` para submeter todas as tarefas. Isso retornará uma `List<Future<Integer>>`.
 * 4. Itere sobre a lista de futuros, obtenha cada resultado com `get()` e some-os.
 * 5. Imprima a soma total e desligue o executor.
 *
 * -----
 *
 * Exercício 3.3 (Agendamento):
 * Objetivo: Agendar uma tarefa para execução periódica.
 * Passos:
 * 1. Crie um `ScheduledExecutorService` com `Executors.newSingleThreadScheduledExecutor()`.
 * 2. Crie uma `Runnable` que imprime a hora atual (`LocalTime.now()`).
 * 3. Agende a tarefa para ser executada a cada 5 segundos, com um atraso inicial de 2 segundos,
 * usando `scheduleAtFixedRate()`.
 * 4. Deixe a thread `main` dormir por 20 segundos para ver a tarefa rodando, e depois
 * desligue o executor.
 */
public class GerenciadorDeTarefas {
}
