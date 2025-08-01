package org.example.topic2_synchronization;

/**
 * Exercício 2.1 e 2.2: Condição de Corrida e Synchronized
 *
 * Objetivo: Demonstrar uma condição de corrida e corrigi-la usando `synchronized`.
 *
 * Passos:
 * 1. Crie uma classe `ContadorSincronizado` com uma variável de instância `int contador = 0;`.
 * 2. Crie um método `incrementar()` que faz `contador++`.
 * 3. Crie uma classe `Main` que:
 * a. Instancia o `ContadorSincronizado`.
 * b. Cria e inicia 10 threads. Cada thread deve chamar o método `incrementar()`
 * 1.000 vezes em um loop.
 * c. Espera todas as threads terminarem (usando `join()`).
 * d. Imprime o valor final do `contador`.
 *
 * 4. **Primeira Execução (Condição de Corrida):** Execute o código. O valor impresso
 * provavelmente será menor que 10.000.
 *
 * 5. **Segunda Execução (Correção):** Modifique o método `incrementar()`
 * adicionando a palavra-chave `synchronized`. Execute novamente e verifique
 * se o resultado é sempre 10.000.
 */

public class ContadorSincronizado {
}
