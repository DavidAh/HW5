package threads;

import java.util.Random;

public class ThreadLogic  {
    //public int loopCount = 5;
    public int index = 0;
    public String type = "Thread-1";

    Random random = new Random();
    int min = 30;
    int max = 60;


    public ThreadLogic(String type, int index) {
        //this.loopCount = loopCount;
        this.index = index;
        this.type      = type;
    }
    
    public void run() {
        //for (int i = 0; i < loopCount; i++) {
        //    final int  index = i;
            int rand = random.nextInt((max - min) + 1) + min;

            long threadId = Thread.currentThread().threadId();

            System.out.println(type + " ThreadId = " + threadId + "index = " + index);
            try {
                Thread.sleep(rand);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //}
    }

}