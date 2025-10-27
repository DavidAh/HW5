
package threads;

import java.util.concurrent.CompletableFuture;

public class ThreadCompletableFuture {
    public static void runSupplySyncThreads(int numThreads) throws Exception {

        CompletableFuture<String>[] futures;

        futures = new CompletableFuture[numThreads];

        for (int i=0; i < numThreads; i++)
        {
            final int index = i;
            futures[i] = CompletableFuture.supplyAsync(() -> {
               ThreadLogic logic = new ThreadLogic("Completable Future supplyAsync", index);
               logic.run();

               //System.out.println("loopCount = " + index);
               return "Result of the async computation";

            });

            // Main thread continues its work without waiting
            System.out.println("Main thread is not blocked.");
        }

        CompletableFuture.allOf(futures).join();
    }



    public static void runAsyncThreads(int numThreads) throws Exception {

        CompletableFuture[] futures;

        futures = new CompletableFuture[numThreads];

        for (int i=0; i < numThreads; i++)
        {
            final int index = i;
 
            futures[i] = CompletableFuture.runAsync(() -> {
            
                //System.out.println("loopCount = " + index);
                ThreadLogic logic = new ThreadLogic("Completable Future runAsync", index);
                logic.run();
                
 
            });
        }

        // Main thread continues its work without waiting
        System.out.println("Main thread is not blocked.");

        // Wait for the tasks to complete (this call is blocking)
        CompletableFuture.allOf(futures).join();

    }   
}