package threads;
import java.util.Random;

public class ThreadRunnableLambda {
    public static void runThreads(int loopCountP) {

        int loopCount = loopCountP > 0 ? loopCountP : 10;

        Thread[] threads = new Thread[loopCount];
 
        Random random = new Random();
        int min = 30;
        int max = 60;

        Runnable task = () -> {
                int rand = random.nextInt((max - min) + 1) + min;

                long threadId = Thread.currentThread().threadId();
                
                try {
                    Thread.sleep(rand); // Sleep for rand milliseconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Runable Thread ID = " + threadId);
        };

        for (int i = 0; i < loopCount; i++) { 
            threads[i] = new Thread(task);
            threads[i].start();

            System.out.println("loopCount= " + i);

            try {
                threads[i].join();
            } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
            }
        }
    }
}

