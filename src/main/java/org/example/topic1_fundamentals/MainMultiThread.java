package org.example.topic1_fundamentals;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercício 1.2 e 1.3: Múltiplas Threads e Sincronização com join()
 * <p>
 * Objetivo: Criar e iniciar múltiplas threads e garantir que a thread principal
 * espere pela finalização de todas elas.
 * <p>
 * Passos:
 * 1. Crie uma classe `MainMultiThread` com o método `main`.
 * 2. Dentro do `main`, crie um array ou lista para armazenar 5 Threads.
 * 3. Em um loop, instancie 5 novas Threads, cada uma com uma nova instância
 * da sua classe `ContadorRunnable` (do exercício 1.1), e adicione-as à lista.
 * 4. Em outro loop, inicie todas as 5 threads com o método `start()`.
 * 5. Em um terceiro loop, chame o método `join()` em cada uma das threads.
 * Isso fará a thread `main` esperar pela conclusão de cada uma.
 * 6. Após o loop de `join()` terminar, imprima a mensagem "Fim do programa.".
 */

public class MainMultiThread {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>(5);

        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(new ContadorRunnable()));
        }

        for (int i = 0; i < 5; i++) {
            threads.get(i).start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Fim do programa.");
    }

}
