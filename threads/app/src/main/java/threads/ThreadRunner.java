package threads;

import java.util.concurrent.ExecutorService;

public class ThreadRunner {
    public static void runThreads(int numThreads, int loopCount) {
        Runnable[] runnable = new Runnable[numThreads];
        try {
            for (int i = 0; i < numThreads; i++) {
                final int index = i;
                runnable[i] = new Runnable() {
                    public void run() {
                        ThreadLogic logic = new ThreadLogic("runnable", index);
                        logic.run();
                    }
                };
                System.out.println("loopCount =" + index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try(ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(numThreads)) {
            for (int i = 0; i < numThreads; i++) {
                executor.submit(runnable[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();    
        }
       
    }

}