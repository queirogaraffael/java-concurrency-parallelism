package org.example.topic1_fundamentals;

/**
 * Exercício 1.1: Contador Básico com Runnable
 * <p>
 * Objetivo: Criar uma classe que implementa Runnable e que, ao ser executada,
 * imprime os números de 1 a 10, fazendo uma pausa de 100 milissegundos
 * entre cada número.
 * <p>
 * Passos:
 * 1. Crie uma classe chamada `ContadorRunnable`.
 * 2. Implemente a interface `Runnable`.
 * 3. No método `run()`, implemente um loop que conte de 1 a 10.
 * 4. Dentro do loop, imprima o número atual e o nome da thread (Thread.currentThread().getName()).
 * 5. Use `Thread.sleep(100)` dentro do loop para a pausa.
 * 6. Lembre-se de tratar a `InterruptedException` com um bloco try-catch.
 */

public class ContadorRunnable {

    public static void main(String[] args) {

        MeuRunabble meuRunabble = new MeuRunabble();

        Thread thread = new Thread(meuRunabble);

        thread.start();
    }

    public static class MeuRunabble implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++){
                String nomeThread = Thread.currentThread().getName();
                System.out.println("Número: " + i + " - Thread: " + nomeThread);
                sleep();
            }

        }
    }

    public static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}
