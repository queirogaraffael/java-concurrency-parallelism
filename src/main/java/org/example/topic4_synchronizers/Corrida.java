package org.example.topic4_synchronizers;

/**
 * Exercício 4.2: CountDownLatch
 *
 * Objetivo: Sincronizar o início de várias threads, que devem esperar por um sinal para começar.
 *
 * Passos:
 * 1. Crie uma classe `Corrida` com um `CountDownLatch` inicializado em 1.
 * 2. Crie uma `Runnable` que representa um corredor. No método `run()`:
 * a. Imprime que o corredor [nome da thread] está pronto.
 * b. Chama `latch.await()` para esperar o sinal da largada.
 * c. Após o `await()` ser liberado, imprime que o corredor [nome da thread] começou a correr.
 * 3. Na `main`:
 * a. Crie um `ExecutorService` para 5 corredores.
 * b. Submeta as 5 tarefas de corredor.
 * c. Imprima "A corrida vai começar em 3 segundos...".
 * d. Espere 3 segundos (`Thread.sleep(3000)`).
 * e. Chame `latch.countDown()` para dar o sinal de largada.
 * f. Desligue o executor.
 */
public class Corrida {
}
