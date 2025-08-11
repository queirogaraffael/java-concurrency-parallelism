package org.example.topic4_synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Exercício 4.1: Semaphore
 * <p>
 * Objetivo: Simular um recurso com capacidade limitada (um estacionamento).
 * <p>
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

    public static final Semaphore SEMAFORO = new Semaphore(3);

    public static void main(String[] args) {

        ExecutorService executor = null;

        Runnable carro = () -> {
            acquire();

            System.out.println(Thread.currentThread().getName() + " entrou no estacionamento");

            sleep(3);

            System.out.println(Thread.currentThread().getName() + " saiu do estacionamento");

            SEMAFORO.release();
        };


        try {
            executor = Executors.newCachedThreadPool();

            for (int i = 0; i < 10; i++) {
                executor.submit(carro);
            }

        } finally {
            if (executor != null) {
                executor.shutdown();
            }
        }

    }

    public static void acquire() {
        try {
            SEMAFORO.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrompida durante acquire: " + e.getMessage());
        }
    }

    public static void sleep(int segundos) {

        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }


}
