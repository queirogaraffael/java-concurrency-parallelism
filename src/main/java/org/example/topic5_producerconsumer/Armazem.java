package org.example.topic5_producerconsumer;
/**
 * Exercício 5.1 e 5.2: Padrão Produtor-Consumidor
 *
 * Objetivo: Implementar o padrão usando BlockingQueue e depois SynchronousQueue.
 *
 * -----
 * Exercício 5.1 (BlockingQueue):
 * Passos:
 * 1. Crie uma `BlockingQueue<Integer>` com capacidade para 5 itens (ex: `new LinkedBlockingQueue<>(5)`).
 * 2. Crie uma `Runnable` "Produtor" que, em um loop infinito:
 * a. Gera um número aleatório.
 * b. Adiciona o número na fila usando `fila.put(numero)`.
 * c. Imprime que produziu o número.
 * d. Espera um tempo (`Thread.sleep()`).
 * 3. Crie uma `Runnable` "Consumidor" que, em um loop infinito:
 * a. Retira um número da fila usando `fila.take()`.
 * b. Imprime que consumiu o número.
 * c. Espera um tempo.
 * 4. Na `main`, inicie uma thread para o produtor e uma para o consumidor.
 *
 * -----
 * Exercício 5.2 (SynchronousQueue):
 * Passos:
 * 1. Troque a `LinkedBlockingQueue` por uma `SynchronousQueue`.
 * 2. Execute novamente. Observe e explique o comportamento: o produtor agora
 * bloqueia até que o consumidor esteja pronto para receber o item.
 */
public class Armazem {
}
