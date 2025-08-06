package org.example.topic2_synchronization;

/**
 * Exercício 2.4: Criando um Deadlock
 * <p>
 * Objetivo: Escrever um código que deliberadamente causa um deadlock entre duas threads.
 * <p>
 * Passos:
 * 1. Crie dois objetos que servirão como recursos (locks). Ex:
 * `private static final Object recurso1 = new Object();`
 * `private static final Object recurso2 = new Object();`
 * 2. Crie uma primeira `Runnable` (pode ser com lambda) que:
 * a. Sincroniza no `recurso1`.
 * b. Imprime "Thread 1: segurando recurso 1...".
 * c. Faz uma pequena pausa (`Thread.sleep(100)`).
 * d. Tenta sincronizar no `recurso2`.
 * <p>
 * 3. Crie uma segunda `Runnable` que faz o oposto:
 * a. Sincroniza no `recurso2`.
 * b. Imprime "Thread 2: segurando recurso 2...".
 * c. Faz uma pequena pausa.
 * d. Tenta sincronizar no `recurso1`.
 * <p>
 * 4. Na `main`, inicie as duas threads. O programa deve "travar" (entrar em deadlock).
 */
public class SimuladorDeadlock {

    private static final Object recurso1 = new Object();
    private static final Object recurso2 = new Object();

    public static void main(String[] args) {

        // Apenas uma thread por vez pode executar esse bloco, usando esse objeto como trava (lock).
        // Quando uma thread entra em um bloco synchronized(objeto), ela adquire o lock (monitor) daquele objeto.
        Runnable r1 = () -> {
            synchronized (recurso1) {
                System.out.println("Thread 1: segurando recurso 1...");
                sleep();

                // tenta sincronizar no 2
                synchronized (recurso2) {
                    System.out.println("Thread 1: tentando pegar recurso 2...");
                }
            }
        };

        Runnable r2 = () -> {
            synchronized (recurso2) {
                System.out.println("Thread 2: segurando recurso 2...");
                sleep();

                synchronized (recurso1) {
                    System.out.println("Thread 2: tentando pegar recurso 1...");

                }
            }
        };

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();

    }

    public static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
