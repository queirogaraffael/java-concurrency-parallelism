package org.example.topic4_synchronizers;
/**
 * Exercício 4.3: CyclicBarrier
 *
 * Objetivo: Fazer com que um grupo de threads espere umas pelas outras em um ponto comum.
 *
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
}
