package org.example.topic3_executors;

import java.util.concurrent.*;

/**
 * Exercício 3.1 (Callable e Future):
 * Objetivo: Criar uma tarefa que retorna um valor e obtê-lo de forma assíncrona.
 * Passos:
 * 1. Crie uma tarefa (`Callable<Integer>`) que calcula o fatorial de um número (ex: 10).
 * Lembre-se que o fatorial de n é n * (n-1) * ... * 1.
 * 2. Crie um `ExecutorService` com `Executors.newSingleThreadExecutor()`.
 * 3. Submeta a tarefa ao executor usando `submit()`, que retornará um `Future<Integer>`.
 * 4. Chame o método `get()` no futuro para obter o resultado e imprima-o.
 * 5. Lembre-se de desligar o executor (`executor.shutdown()`).
 */
public class Exercicio31CallableFuture {

    public static void main(String[] args) {
        ExecutorService executorService = null;

        try {
            executorService = Executors.newSingleThreadExecutor();

            Callable<Integer> tarefa = () -> {
                Integer n = 10;
                Integer resultado = n;

                while (n > 1) {
                    resultado *= (n - 1);

                    n -= 1;
                }
                return resultado;
            };

            Future<Integer> future = executorService.submit(tarefa);

            Integer resultado = future.get(2, TimeUnit.SECONDS);
            System.out.println("Resultado: " + resultado);

        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }

    }
}
