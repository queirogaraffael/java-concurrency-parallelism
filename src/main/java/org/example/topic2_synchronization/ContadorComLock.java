package org.example.topic2_synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Exercício 2.3: Sincronização com ReentrantLock
 *
 * Objetivo: Resolver o mesmo problema do contador, mas utilizando `ReentrantLock`.
 *
 * Passos:
 * 1. Crie uma classe `ContadorComLock`.
 * 2. Adicione as variáveis de instância: `int contador = 0;` e
 * `private final Lock lock = new ReentrantLock();`
 *
 *
 * 3. No método `incrementar()`, use `lock.lock()` no início.
 * 4. **IMPORTANTE:** Coloque o código de incremento e a chamada `lock.unlock()`
 * dentro de um bloco `try-finally` para garantir que o lock seja sempre liberado.
 * 5. Execute com a mesma classe `Main` do exercício anterior e verifique o resultado.
 */
public class ContadorComLock {

    int contador = 0;

    private final Lock lock = new ReentrantLock();



}
