package org.example.topic5_producerconsumer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/*
 * Exercício 5.2 (SynchronousQueue):
 * Passos:
 * 1. Troque a `LinkedBlockingQueue` por uma `SynchronousQueue`.
 * 2. Execute novamente. Observe e explique o comportamento: o produtor agora
 * bloqueia até que o consumidor esteja pronto para receber o item.
 */
public class ArmazemSynchronousQueue {

    private static final SynchronousQueue<Integer> FILA = new SynchronousQueue<>();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        Random random = new Random();

        Runnable produtor = () -> {

            while (true) {
                int numero = random.nextInt();
                put(numero);
                System.out.println("Produtor: " + numero);

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
            // Bloqueia até que um put() seja chamado por outra thread
            return FILA.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return null;
        }
    }

    private static void put(int numero) {
        try {
            // Bloqueia até que um take() seja chamado por outra thread
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
