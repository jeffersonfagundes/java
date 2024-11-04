package release21;

import java.util.concurrent.Executors;


/**
 * Somente usar threads virtuais quando tiver uma dependencia externa, pois ele move o contexto para um heap memory:
 *
 * Exemplo de quando usar:
 * Consulta demorada de banco de dados:
 * Multiplos client de APIs
 * Qual quer outro cenarios não se torna vantajoso devido ao custo de gerenciar um thread virtual
 *
 * OBS: CompletableFuture.runAsync ja utiliza virtual thread a partir do Java 21
 *
 * */
public class TestandoVirtualThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.ofVirtual().start(() -> System.out.println("Test Thread Virtual"));
        thread.join();

        //Usando Thread builder - vc pode dar uma nome para a thread
        Thread.Builder builder = Thread.ofVirtual().name("testThread-", 0);
        Runnable task = () -> {
            System.out.println("Thread ID: " + Thread.currentThread().threadId());
        };

        // name "testThread-0"
        Thread t1 = builder.start(task);
        t1.join();
        System.out.println(t1.getName() + " terminated");

        // name "testThread-1"
        Thread t2 = builder.start(task);
        t2.join();
        System.out.println(t2.getName() + " terminated");

        //Usando Executores

        Executors.newVirtualThreadPerTaskExecutor().submit(() -> {
            System.out.println(runThread1());
            System.out.println(runThread2());
        });
    }

    static String runThread1() {
        return "Teste Executors 01";
    }

    static String runThread2() {
        return "Teste Executors 02";
    }
}
