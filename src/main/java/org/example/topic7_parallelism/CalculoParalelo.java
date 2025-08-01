package org.example.topic7_parallelism;
/**
 * Exercícios do Tópico 7: Paralelismo com Fork/Join e Streams
 *
 * Você pode resolver todos os exercícios deste tópico em uma única classe `CalculoParalelo`.
 *
 * -----
 *
 * Exercício 7.1 (Fork/Join):
 * Objetivo: Implementar uma tarefa recursiva para processamento paralelo.
 * Passos:
 * 1. Crie uma classe `SomaDeArray` que herda de `RecursiveTask<Long>`.
 * 2. Ela deve receber um `long[]` array, `start` e `end` no construtor.
 * 3. No método `compute()`:
 * a. Se o tamanho do segmento (`end - start`) for menor que um limite (ex: 1000), some os elementos em um loop simples.
 * b. Caso contrário, divida a tarefa em duas, crie duas novas `SomaDeArray` para cada metade.
 * c. Chame `subtarefa1.fork()` e `subtarefa2.compute()`.
 * d. Retorne `subtarefa2.join() + resultadoDaSubtarefa1`.
 * 4. Na `main`, crie um `ForkJoinPool` e use-o para `invoke()` a tarefa principal.
 *
 * -----
 *
 * Exercício 7.2 (Streams Paralelos):
 * Objetivo: Resolver o mesmo problema de soma, mas de forma muito mais simples.
 * Passos:
 * 1. Crie um array grande de números.
 * 2. Use `Arrays.stream(meuArray).parallel().sum()` para obter o resultado.
 * 3. Compare a simplicidade do código.
 *
 * -----
 *
 * Exercício 7.3 (Análise de Performance):
 * Objetivo: Comparar o tempo de execução de streams sequenciais e paralelos.
 * Passos:
 * 1. Crie uma `List<Double>` com 20 milhões de números aleatórios.
 * 2. Meça o tempo (usando `System.currentTimeMillis()`) para processar a lista com um stream sequencial,
 * aplicando uma operação complexa (ex: `Math.log(Math.sqrt(numero))`).
 * 3. Meça o tempo novamente para a mesma operação, mas usando `.parallelStream()`.
 * 4. Imprima e compare os tempos.
 */

public class CalculoParalelo {
}
