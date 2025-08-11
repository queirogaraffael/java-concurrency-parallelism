package org.example.topic7_parallelism;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Exercício 7.3 (Análise de Performance):
 * Objetivo: Comparar o tempo de execução de streams sequenciais e paralelos.
 * Passos:
 * 1. Crie uma `List<Double>` com 20 milhões de números aleatórios.
 * 2. Meça o tempo (usando `System.currentTimeMillis()`) para processar a lista com um stream sequencial,
 * aplicando uma operação complexa (ex: `Math.log(Math.sqrt(numero))`).
 * 3. Meça o tempo novamente para a mesma operação, mas usando `.parallelStream()`.
 * 4. Imprima e compare os tempos.
 */
public class AnaliseDePerformance {
    public static void main(String[] args) {

        int tamanho = 20_000_000;
        Random random = new Random();

        List<Double> numeros = new ArrayList<>(tamanho);

        for (int i = 0; i < tamanho; i++) {
            numeros.add(random.nextDouble());
        }

        long inicioSequencial = System.currentTimeMillis();
        double somaSequencial = numeros.stream().mapToDouble(i -> Math.log(Math.sqrt(i))).sum();
        long fimSequencial = System.currentTimeMillis();
        System.out.println("Soma: " + somaSequencial + " - Tempo com Sequencial: " + (fimSequencial - inicioSequencial) + " ms");

        long inicioParalelo = System.currentTimeMillis();
        double somaParalelo = numeros.parallelStream()
                .mapToDouble(i -> Math.log(Math.sqrt(i)))
                .sum();
        long fimParalelo = System.currentTimeMillis();
        System.out.println("Soma: " + somaParalelo + " - Tempo com parallel: " + (fimParalelo - inicioParalelo) + " ms");

    }
}
