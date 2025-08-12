package org.example.topic6_async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * Exercício 6.2 (Combinando Futures):
 * Objetivo: Executar duas tarefas em paralelo e combinar seus resultados.
 * Passos:
 * 1. Crie um `CompletableFuture<Double>` `futureDolar` que busca a cotação do Dólar (espere 2s e retorne um valor).
 * 2. Crie um `CompletableFuture<Double>` `futureEuro` que busca a cotação do Euro (espere 2s e retorne outro valor).
 * 3. Use `futureDolar.thenCombine(futureEuro, (dolar, euro) -> ...)` para, quando ambos terminarem,
 *    calcular e imprimir a diferença entre eles.
 * 4. Chame `.join()` no final para esperar a combinação.
 */
public class CombinandoFutures {

    public static void main(String[] args) {
        CompletableFuture<Void> future = futureDolar().thenCombine(futureEuro(), (dolar, euro) -> (dolar - euro))
                .thenAccept(diferenca -> System.out.println("Diferença final: " + diferenca));

        future.join();

    }

    private static CompletableFuture<Double> futureDolar() {
        return CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            System.out.println("Iniciando a cotação do dólar na thread: " + Thread.currentThread().getName());
            sleep(2);
            return random.nextDouble();
        });
    }

    private static CompletableFuture<Double> futureEuro() {
        return CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            System.out.println("Iniciando a cotação do euro na thread: " + Thread.currentThread().getName());
            sleep(2);
            return random.nextDouble();
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
