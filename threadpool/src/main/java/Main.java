import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    static int BOUND = 10;
    static int N_PRODUCERS = 4;
    static int N_CONSUMERS = 4;
    static int poisonPill = Integer.MAX_VALUE;
    static int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingDeque(BOUND);
        for (int i = 0; i < N_PRODUCERS; i++) {
            new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer)).start();
        }
        for (int j = 0; j < N_CONSUMERS; j++) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }
    }
}
