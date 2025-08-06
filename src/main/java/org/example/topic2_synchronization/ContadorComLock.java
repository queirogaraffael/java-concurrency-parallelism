package org.example.topic2_synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Exercício 2.3: Sincronização com ReentrantLock
 * <p>
 * Objetivo: Resolver o mesmo problema do contador, mas utilizando `ReentrantLock`.
 * <p>
 * Passos:
 * 1. Crie uma classe `ContadorComLock`.
 * 2. Adicione as variáveis de instância: `int contador = 0;` e
 * `private final Lock lock = new ReentrantLock();`
 * 3. No método `incrementar()`, use `lock.lock()` no início.
 * 4. **IMPORTANTE:** Coloque o código de incremento e a chamada `lock.unlock()`
 * dentro de um bloco `try-finally` para garantir que o lock seja sempre liberado.
 * 5. Execute com a mesma classe `Main` do exercício anterior e verifique o resultado.
 */
public class ContadorComLock {

    public int contador = 0;

    private final Lock lock = new ReentrantLock();

    Runnable implementar = () -> {
        for (int i = 0; i < 1000; i++) {
            lock.lock();

            try {
                contador++;

            } finally {
                lock.unlock();
            }
        }
    };

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>(10);

        ContadorComLock contadorComLock = new ContadorComLock();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(contadorComLock.implementar));
        }

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }

        for (int i = 0; i < threads.size(); i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Valor final do contador: " + contadorComLock.getContador());
    }

    public int getContador() {
        return contador;
    }

}
