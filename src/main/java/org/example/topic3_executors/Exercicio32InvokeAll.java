package org.example.topic3_executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Exercício 3.2 (InvokeAll):
 * Objetivo: Executar um lote de tarefas e coletar todos os resultados.
 * Passos:
 * 1. Crie uma lista de `Callable<Integer>`. Adicione 5 tarefas de cálculo de fatorial nela.
 * 2. Crie um `ExecutorService` com `Executors.newFixedThreadPool(3)`.
 * 3. Use `invokeAll()` para submeter todas as tarefas. Isso retornará uma `List<Future<Integer>>`.
 * 4. Itere sobre a lista de futuros, obtenha cada resultado com `get()` e some-os.
 * 5. Imprima a soma total e desligue o executor.
 */
public class Exercicio32InvokeAll {

    public static void main(String[] args) {

        ExecutorService executorService = null;

        Callable<Integer> tarefa = () -> {
            int n = 10;
            int resultado = n;

            while (n > 1) {
                resultado *= (n - 1);

                n -= 1;
            }
            return resultado;
        };

        try {
            executorService = Executors.newFixedThreadPool(3);

            List<Callable<Integer>> tarefas = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                tarefas.add(tarefa);
            }

            // invokeAll já é bloqueante, ent não precisa colocar sleep
            List<Future<Integer>> futures = executorService.invokeAll(tarefas);

            Integer resultado = 0;

            for (Future<Integer> future : futures) {
                resultado += future.get();
            }

            System.out.println("Resultado: " + resultado);


        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Execução interrompida: " + e.getMessage());
        } catch (ExecutionException e) {
            System.err.println("Erro na execução: " + e.getCause());
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }


    }
}
