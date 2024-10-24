package day4.extraCodeReferences;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecSrv {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        var threadFactory = Thread.ofVirtual().factory();

        var executorService = Executors.newThreadPerTaskExecutor(threadFactory);

//        var executorService = Executors.newFixedThreadPool(5, threadFactory);
        System.out.println("Submission Starts");
        long startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1, 15_00000)
                .forEach(n -> executorService.submit(new Task(n)));

        executorService.shutdown(); // Decided to shut down,
                                    // continue finishing previous tasks.
                                    // But won't accept any new ones.


//        executorService.submit(new Task(23));  // throw error.

        System.out.println("Submission Ends");

        while(!executorService.isTerminated()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Executions End");
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time taken: " + (endTime - startTime));


    }
}

