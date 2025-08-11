package org.example.topic3_executors;

/**
 * Exercício 3.2 (InvokeAll):
 * Objetivo: Executar um lote de tarefas e coletar todos os resultados.
 * Passos:
 * 1. Crie uma lista de `Callable<Integer>`. Adicione 5 tarefas de cálculo de fatorial nela.
 * 2. Crie um `ExecutorService` com `Executors.newFixedThreadPool(3)`.
 * 3. Use `invokeAll()` para submeter todas as tarefas. Isso retornará uma `List<Future<Integer>>`.
 * 4. Itere sobre a lista de futuros, obtenha cada resultado com `get()` e some-os.
 * 5. Imprima a soma total e desligue o executor.
 */
public class Exercicio32InvokeAll {
}
