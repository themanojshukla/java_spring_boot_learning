package day4;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {

    public static void main(String[] args) {


        var threadFactory = Thread.ofVirtual().factory(); //  Platform thread - 30 Years ago

        ExecutorService executor = Executors.newThreadPerTaskExecutor(threadFactory);

        var startTime = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            executor.submit(new MyTask(i));
        }

        executor.shutdown(); // not accept new submission, but cont to run prev.


        while (!executor.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        var endTime = System.currentTimeMillis();
        System.out.println("Finished in " + (endTime - startTime) + " ms");

    }

}

class MyTask implements Runnable{

    private final int taskId;


    public MyTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Starting " + taskId + "  " + Thread.currentThread());
            Thread.sleep(5000); // Blocking Operation, on platform Thread/ but for VT
            System.out.println("Ending " + taskId + "  " + Thread.currentThread());
        } catch (InterruptedException ignore) {}
    }
}



/*
Starting 1  Thread[#22,Thread-1,5,main]
// Blocked - Thread-1 is blocked
Ending 1  Thread[#22,Thread-1,5,main]

Starting 4  Thread[#25,Thread-4,5,main]
Starting 2  Thread[#23,Thread-2,5,main]
Starting 3  Thread[#24,Thread-3,5,main]
Starting 0  Thread[#21,Thread-0,5,main]
Ending 2  Thread[#23,Thread-2,5,main]
Ending 4  Thread[#25,Thread-4,5,main]
Ending 3  Thread[#24,Thread-3,5,main]
Ending 0  Thread[#21,Thread-0,5,main]
Finished in 5114 ms
 */

// Starting 4  VirtualThread[#29]/runnable@ForkJoinPool-1-worker-5
// worker-5 - not waiting
// Ending 4  VirtualThread[#29]/runnable@ForkJoinPool-1-worker-1










