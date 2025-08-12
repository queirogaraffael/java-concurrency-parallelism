package org.example.topic6_async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * Exercício 6.1 (Cadeia de Operações):
 * Objetivo: Compor uma sequência de operações assíncronas.
 * Passos:
 * 1. Crie um `CompletableFuture<Integer>` usando `supplyAsync` que simula a busca de um ID de usuário
 * (espere 1s e retorne um número).
 * 2. Encadear com `thenApply` para, a partir do ID, buscar o nome do usuário (espere 1s e retorne uma String).
 * 3. Encadear com `thenApply` para transformar o nome em maiúsculas.
 * 4. Encadear com `thenAccept` para imprimir o resultado final.
 * 5. Na `main`, chame `.join()` no final para esperar a conclusão de toda a cadeia.
 */
public class CadeiaDeOperacoes {

    public static void main(String[] args) {
        CompletableFuture<Void> future = processe().thenCompose(CadeiaDeOperacoes::buscarNomePorIdAsync)
                .thenApply(String::toUpperCase)
                .thenAccept(s -> System.out.println("Resultado final: " + s));

        future.join();

    }

    private static CompletableFuture<Integer> processe() {
        return CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            System.out.println("Iniciando processamento na thread: " + Thread.currentThread().getName());
            sleep(1);
            return random.nextInt(100);
        });
    }

    private static CompletableFuture<String> buscarNomePorIdAsync(int id) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Buscando nome para o ID " + id);
            sleep(1);
            switch (id) {
                case 1: return "Raffael";
                default: return "Raffael Queiroga";
            }
        });
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
