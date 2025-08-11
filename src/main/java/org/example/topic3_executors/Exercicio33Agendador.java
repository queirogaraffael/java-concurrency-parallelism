package org.example.topic3_executors;


/**
 * Exercício 3.3 (Agendamento):
 * Objetivo: Agendar uma tarefa para execução periódica.
 * Passos:
 * 1. Crie um `ScheduledExecutorService` com `Executors.newSingleThreadScheduledExecutor()`.
 * 2. Crie uma `Runnable` que imprime a hora atual (`LocalTime.now()`).
 * 3. Agende a tarefa para ser executada a cada 5 segundos, com um atraso inicial de 2 segundos,
 * usando `scheduleAtFixedRate()`.
 * 4. Deixe a thread `main` dormir por 20 segundos para ver a tarefa rodando, e depois
 * desligue o executor.
 */
public class Exercicio33Agendador {
}
