package org.example.topic7_parallelism;

import java.util.Arrays;

/**
 * Exercício 7.2 (Streams Paralelos):
 * Objetivo: Resolver o mesmo problema de soma, mas de forma muito mais simples.
 * Passos:
 * 1. Crie um array grande de números.
 * 2. Use `Arrays.stream(meuArray).parallel().sum()` para obter o resultado.
 * 3. Compare a simplicidade do código.
 */
public class SomaComStreamsParalelos {
    public static void main(String[] args) {

        int[] numeros = new int[20_000_000];

        for(int i = 0; i < numeros.length; i++){
            numeros[i] = i;
        }

        long soma = Arrays.stream(numeros).parallel().mapToLong(i -> i).sum();

        System.out.println("Soma: "+ soma);
    }
}
