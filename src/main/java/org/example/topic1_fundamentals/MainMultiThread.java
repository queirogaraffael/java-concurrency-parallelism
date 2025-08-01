package org.example.topic1_fundamentals;

/**
 * Exercício 1.2 e 1.3: Múltiplas Threads e Sincronização com join()
 *
 * Objetivo: Criar e iniciar múltiplas threads e garantir que a thread principal
 * espere pela finalização de todas elas.
 *
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
}
