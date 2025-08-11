package org.example.topic3_executors;


import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Exercício 3.3 (Agendamento):
 * Objetivo: Agendar uma tarefa para execução periódica.
 * Passos:
 * 1. Crie um `ScheduledExecutorService` com `Executors.newSingleThreadScheduledExecutor()`.
 * 2. Crie uma `Runnable` que imprime a hora atual (`LocalTime.now()`).
 * 3. Agende a tarefa para ser executada a cada 5 segundos, com um atraso inicial de 2 segundos,
 * usando `scheduleAtFixedRate()`.
 *
 * 4. Deixe a thread `main` dormir por 20 segundos para ver a tarefa rodando, e depois
 * desligue o executor.
 */
public class Exercicio33Agendador {


    public static void main(String[] args) {

        ScheduledExecutorService executor = null;

        Runnable tarefa = () -> {
            System.out.println(LocalTime.now());
        };

        try{
            executor = Executors.newSingleThreadScheduledExecutor();

            executor.scheduleAtFixedRate(tarefa, 2, 5, TimeUnit.SECONDS);

            sleep(20);

        }finally {
            if(executor!= null){
                executor.shutdown();
            }
        }

    }

    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds * 1000L);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.err.println(e.getMessage());
        }
    }
}
