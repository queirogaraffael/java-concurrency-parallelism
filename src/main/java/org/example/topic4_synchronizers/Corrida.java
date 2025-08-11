package org.example.topic4_synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exercício 4.2: CountDownLatch
 * <p>
 * Objetivo: Sincronizar o início de várias threads, que devem esperar por um sinal para começar.
 * <p>
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

    public static final CountDownLatch latch = new CountDownLatch(1);


    public static void main(String[] args) {

        Runnable corredor = () -> {
            System.out.println(Thread.currentThread().getName() + " está pronta");
            await();
            System.out.println(Thread.currentThread().getName() + " começou a correr");

        };

        ExecutorService executor = null;

        try {
            executor = Executors.newFixedThreadPool(5);

            for (int i = 0; i < 5; i++) {
                executor.submit(corredor);
            }

            System.out.println("A corrida vai começar em 3 segundos...");
            sleep(3);

            latch.countDown();

            sleep(5);

            System.out.println("Fim da corrida");


        } finally {
            if (executor != null) {
                executor.shutdown();
            }
        }
    }

    private static void await() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }

}
