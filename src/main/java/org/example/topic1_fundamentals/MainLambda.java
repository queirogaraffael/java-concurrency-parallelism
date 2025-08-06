package org.example.topic1_fundamentals;

/**
 * Exercício 1.4: Refatorando para Lambda
 *
 * Objetivo: Criar a mesma funcionalidade do contador, mas usando uma expressão lambda
 * em vez de uma classe separada.
 *
 * Passos:
 * 1. Crie uma classe `MainLambda` com um método `main`.
 * 2. Dentro do `main`, crie uma `Thread` passando uma expressão lambda diretamente
 * no construtor: `new Thread(() -> { ... })`.
 * 3. A lógica da lambda deve ser a mesma do método `run()` do exercício 1.1:
 * um loop de 1 a 10 que imprime o número e faz uma pausa de 100ms.
 * 4. Inicie a thread.
 */

public class MainLambda {

    public static void main(String[] args) {

        Runnable meuRunabble = () -> {
            for (int i = 1; i <= 10; i++){
                String nomeThread = Thread.currentThread().getName();
                System.out.println("Número: " + i + " - Thread: " + nomeThread);
                sleep();
            }

        };

        Thread thread = new Thread(meuRunabble);

        thread.start();
    }

    public static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
