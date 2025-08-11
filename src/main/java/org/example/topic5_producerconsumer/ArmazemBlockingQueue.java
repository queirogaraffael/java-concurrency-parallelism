package org.example.topic5_producerconsumer;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/*
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
 */
public class ArmazemBlockingQueue {

    // o put e o take so bloqueariam se usasse a capacidade maxima
    private static final BlockingQueue<Integer> FILA = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        Random random = new Random();

        Runnable produtor = () -> {

            while (true) {
                int numero = random.nextInt();
                put(numero);
                System.out.println("Produtor: "+ numero);

                sleep(2);

            }

        };

        Runnable consumidor = () -> {
            while (true) {
                int numero = take();
                System.out.println("Consumidor " + numero);
                sleep(2);
            }
        };

        executor.submit(produtor);
        executor.submit(consumidor);

        executor.shutdown();


    }

    private static Integer take() {
        try {
            return FILA.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return null;
        }
    }

    private static void put(int numero) {
        try {
            FILA.put(numero);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private static void sleep(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }

}
