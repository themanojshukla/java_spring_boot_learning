package day4.extraCodeReferences;

import java.util.Random;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadExample {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ThreadFactory threadFactory = Thread.ofPlatform().factory();
//        ThreadFactory threadFactory = Thread.ofVirtual().factory();

        Runnable task = () -> {
            try {
                Random random = new Random();
                var max = random.nextInt(200) + 1000;
                var set = IntStream.rangeClosed(1, max)
                        .mapToObj(s -> "HelloThisIsThreadLongWordDummyDataUnique" + s)
                        .collect(Collectors.toSet());
                Thread.sleep(30000);
                System.out.println(set.size());
            } catch (InterruptedException ignore) {}
        };


//        new Thread(task).start();


        System.out.println("Starting");
        int MAX_THREAD = 25_000;
        for(int i=0; i<MAX_THREAD; i++) {
//            new Thread(task).start();

            threadFactory.newThread(task).start();
        }

        // create virtual thread
//        IntStream.rangeClosed(1, MAX_THREAD).forEach(x -> threadFactory.newThread(task));

         try {
             Thread.sleep(30000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         long endTime = System.currentTimeMillis();
        System.out.println("Finish: " + (endTime-startTime-1000) + " ms");

    }



}
