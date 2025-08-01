package org.example.topic2_synchronization;

/**
 * Exercício 2.4: Criando um Deadlock
 *
 * Objetivo: Escrever um código que deliberadamente causa um deadlock entre duas threads.
 *
 * Passos:
 * 1. Crie dois objetos que servirão como recursos (locks). Ex:
 * `private static final Object recurso1 = new Object();`
 * `private static final Object recurso2 = new Object();`
 *
 * 2. Crie uma primeira `Runnable` (pode ser com lambda) que:
 * a. Sincroniza no `recurso1`.
 * b. Imprime "Thread 1: segurando recurso 1...".
 * c. Faz uma pequena pausa (`Thread.sleep(100)`).
 * d. Tenta sincronizar no `recurso2`.
 *
 * 3. Crie uma segunda `Runnable` que faz o oposto:
 * a. Sincroniza no `recurso2`.
 * b. Imprime "Thread 2: segurando recurso 2...".
 * c. Faz uma pequena pausa.
 * d. Tenta sincronizar no `recurso1`.
 *
 * 4. Na `main`, inicie as duas threads. O programa deve "travar" (entrar em deadlock).
 */
public class SimuladorDeadlock {
}
