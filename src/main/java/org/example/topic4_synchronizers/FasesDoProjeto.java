package org.example.topic4_synchronizers;

import java.util.concurrent.*;

/**
 * Exercício 4.3: CyclicBarrier
 * <p>
 * Objetivo: Fazer com que um grupo de threads espere umas pelas outras em um ponto comum.
 * Passos:
 * 1. Crie uma `Runnable` para a ação da barreira, que simplesmente imprime
 * "Todos os desenvolvedores se reuniram, iniciando a próxima fase!".
 * 2. Crie uma `CyclicBarrier` para 4 participantes e passe a ação acima no construtor.
 * 3. Crie uma `Runnable` para o desenvolvedor. No método `run()`:
 * a. Simule um trabalho com `Thread.sleep()`.
 * b. Imprime que o desenvolvedor [nome da thread] terminou sua tarefa.
 * c. Chama `barrier.await()`.
 * 4. Na `main`, crie um `ExecutorService` e submeta as 4 tarefas de desenvolvedor.
 * 5. Observe como a ação da barreira só é executada quando o último desenvolvedor chega.
 */
public class FasesDoProjeto {

    public static void main(String[] args) {

        Runnable finalizacao = () -> {
            System.out.println("Todos os desenvolvedores se reuniram, iniciando a próxima fase!");
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, finalizacao);

        Runnable desenvolvedor = () -> {
            int segundos = ThreadLocalRandom.current().nextInt(1,4);
            sleep(segundos);

            System.out.println(Thread.currentThread().getName() + " terminou a tarefa");
            await(cyclicBarrier);
        };

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 4; i++) {
            executor.submit(desenvolvedor);
        }

        executor.shutdown();

    }

    private static void await(CyclicBarrier cyclicBarrier) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


    public static void sleep(int segundos) {

        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }

}
