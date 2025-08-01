package org.example.topic6_async;
/**
 * Exercícios do Tópico 6: CompletableFuture
 *
 * Você pode resolver todos os exercícios deste tópico em uma única classe `BuscaDeDados`.
 *
 * -----
 *
 * Exercício 6.1 (Cadeia de Operações):
 * Objetivo: Compor uma sequência de operações assíncronas.
 * Passos:
 * 1. Crie um `CompletableFuture<Integer>` usando `supplyAsync` que simula a busca de um ID de usuário
 * (espere 1s e retorne um número).
 * 2. Encadear com `thenApply` para, a partir do ID, buscar o nome do usuário (espere 1s e retorne uma String).
 * 3. Encadear com `thenApply` para transformar o nome em maiúsculas.
 * 4. Encadear com `thenAccept` para imprimir o resultado final.
 * 5. Na `main`, chame `.join()` no final para esperar a conclusão de toda a cadeia.
 *
 * -----
 *
 * Exercício 6.2 (Combinando Futures):
 * Objetivo: Executar duas tarefas em paralelo e combinar seus resultados.
 * Passos:
 * 1. Crie um `CompletableFuture<Double>` `futureDolar` que busca a cotação do Dólar (espere 2s e retorne um valor).
 * 2. Crie um `CompletableFuture<Double>` `futureEuro` que busca a cotação do Euro (espere 2s e retorne outro valor).
 * 3. Use `futureDolar.thenCombine(futureEuro, (dolar, euro) -> ...)` para, quando ambos terminarem,
 * calcular e imprimir a diferença entre eles.
 * 4. Chame `.join()` no final para esperar a combinação.
 */

public class BuscaDeDados {
}
