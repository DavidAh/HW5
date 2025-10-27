package threads;

import java.util.concurrent.ExecutorService;
import java.util.Random;

public class ThreadExecutorService {
    public static void runThreads(int numThreads) {
        Runnable[] runnable = new Runnable[numThreads];
        Random random = new Random();

        //int min = 30;
        //int max = 60;

        for (int i = 0; i < numThreads; i++) {
            final int index = i;
            runnable[i] = new Runnable() {

                public void run(){
                   ThreadLogic logic = new ThreadLogic("Executor Service", index);
                   logic.run();
                }
            };

            //    public void run() {
 
            //       int rand = random.nextInt((max - min) + 1) + min;

            //      long threadId = Thread.currentThread().threadId();
                
            //       try {
            //           Thread.sleep(rand); // Sleep for rand milliseconds
            //        } catch (InterruptedException e) {
            //            Thread.currentThread().interrupt();
            //        }
            //        System.out.println("Executor Thread ID = " + threadId + " loopcount =  " + index);
            //
            //    }
            //};
        }

        try(ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(numThreads)) {
            for (int i = 0; i < numThreads; i++) {
                final int index = i;
                executor.submit(runnable[i]);
                //System.out.println("loopcount =  " + index);
            }
        } catch (Exception e) {
            e.printStackTrace();    
        }
       
    }

}