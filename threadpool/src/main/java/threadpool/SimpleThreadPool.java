package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("task " + i);
            executorService.execute(worker);
        }
        executorService.shutdown();
    }
}
