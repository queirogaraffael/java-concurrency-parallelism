package org.example.topic4_synchronizers;

/**
 * Exercício 4.1: Semaphore
 *
 * Objetivo: Simular um recurso com capacidade limitada (um estacionamento).
 *
 * Passos:
 * 1. Crie uma classe `Estacionamento` com um `Semaphore` inicializado com 3 permissões (vagas).
 * 2. Crie uma `Runnable` que representa um carro. No método `run()`:
 * a. O carro tenta "entrar" no estacionamento chamando `semaphore.acquire()`.
 * b. Imprime uma mensagem que o carro [nome da thread] entrou.
 * c. Simula um tempo estacionado com `Thread.sleep()` por alguns segundos.
 * d. O carro "sai" do estacionamento chamando `semaphore.release()`.
 * e. Imprime uma mensagem que o carro [nome da thread] saiu.
 * 3. Na `main`, crie um `ExecutorService` e submeta 10 tarefas (carros).
 * 4. Observe como apenas 3 carros conseguem entrar por vez.
 */
public class Estacionamento {
}
